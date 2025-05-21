package com.bitsnbyte_product.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Data
public class UserDTO {

    private String username;
    private String userPassword;
}
