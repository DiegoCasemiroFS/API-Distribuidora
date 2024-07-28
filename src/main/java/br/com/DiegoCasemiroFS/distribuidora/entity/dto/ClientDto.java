package br.com.DiegoCasemiroFS.distribuidora.entity.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ClientDto {

    private String address;

    @Email
    private String email;

    private String phone;
}
