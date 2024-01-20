package com.example.securityappkinansaad.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Eren
 **/
@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;
}
