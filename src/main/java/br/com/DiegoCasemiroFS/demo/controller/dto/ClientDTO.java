package br.com.DiegoCasemiroFS.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String name;
    private String address;
    private String email;
    private String phone;
}