package ru.anvarzhonov.sbrf.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewUserRequest implements Serializable {
    private String username;
    private String password;
    private String email;
}
