package com.bitsnbyte_product.repositories;


import com.bitsnbyte_product.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    /**
     * Finds a user by their username.
     * <p>
     * - This method uses a case-insensitive JPQL query by converting both the input
     *   and stored username to lowercase using the LOWER() function.
     * - Ensures that usernames like 'John', 'john', and 'JOHN' are treated equally.
     * <p>
     * ------------------------------------------------------------
     * Example of a case-sensitive query (not recommended here):
     * @Query("SELECT u FROM User u WHERE u.username = :username")
     * <p>
     * If using derived query methods:
     * Optional<User> findByUserName(String username); // Case-sensitive
     * Optional<User> findByUserNameIgnoreCase(String username); // Case-insensitive
     */

    @Query(value = "SELECT * FROM users WHERE LOWER(username) = LOWER(:username)", nativeQuery = true)
    Optional<User> findByUserName(@Param("username") String username);



}
