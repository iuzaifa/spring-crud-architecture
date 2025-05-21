package com.bitsnbyte_product.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtUtil {

    private static String secretKey;

    /**
     * Constructor for JwtUtil.
     * Generates a random 256-bit (32-byte) secret key for signing JWT tokens,
     * then encodes it using Base64 for safe storage/transmission.
     */
    public JwtUtil(){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32];
        random.nextBytes(key);
        secretKey = Base64.getEncoder().encodeToString(key);
    }

    /**
     * Retrieves the cryptographic signing key for verifying JWT tokens.
     *
     * @return A Key object used for HMAC SHA-based signing.
     */
    private Key getSingnedkey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String generateToken(String username, List<String> roles ){
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*2))
                .signWith(getSingnedkey(), SignatureAlgorithm.HS256)
                .compact();
    }


    /**
     * Validates the given JWT token by comparing the extracted username and checking if the token is not expired.
     *
     * @param token the JWT token to validate
     * @param username the username to match with the one extracted from the token
     * @return true if the token is valid (username matches and not expired), false otherwise
     */
    public Boolean validToken(String token, String username){
        return (extractUsername(token).equals(username) && !isTokenExpired(token));
    }


    /**
     * Extracts the username (subject) from the JWT token.
     *
     * @param token the JWT token
     * @return the username embedded in the token
     */
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }


    /**
     * Extracts the expiration date from the JWT token.
     *
     * @param token the JWT token
     * @return the expiration date of the token
     */
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }


    /**
     * Checks whether the given JWT token has expired.
     *
     * @param token the JWT token
     * @return true if the token is expired, false otherwise
     */
    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }


    /**
     * Extracts the roles assigned to the user from the JWT token.
     *
     * @param token the JWT token
     * @return a list of roles present in the token
     */
    public List<String> extractRole(String token){
        return extractClaim(token, claims -> claims.get("roles", List.class));
    }



    /**
     * Extracts a specific claim from a JWT token using a provided resolver function.
     *
     * @param <T>            The type of the claim to extract.
     * @param token          The JWT token from which the claim is to be extracted.
     * @param claimsResolver A function that takes Claims and returns a specific claim of type T.
     * @return The extracted claim.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        // Parse the JWT token using the signing key to retrieve the claims (payload).
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSingnedkey())// Set the signing key used to validate the token
                .build()
                .parseClaimsJws(token) // Parse the token
                .getBody();            // Get the token body (claims)

        // Apply the resolver function to extract the desired claim from the claims object.
        return claimsResolver.apply(claims);
    }
}

