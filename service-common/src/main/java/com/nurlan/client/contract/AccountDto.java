package com.nurlan.client.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id;

    private String username;

    private String name;

    private String surname;

    private String email;

    private LocalDate birthDate;

    public String getNameSurname(){
        return this.name + " " + this.surname;
    }


}
