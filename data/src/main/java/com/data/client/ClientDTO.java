package com.data.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id;

    private String email;

    private String fullname;

    private String birthday;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.email = client.getEmail();
        this.fullname = client.getFullname();
        this.birthday = client.getBirthday();
    }

}