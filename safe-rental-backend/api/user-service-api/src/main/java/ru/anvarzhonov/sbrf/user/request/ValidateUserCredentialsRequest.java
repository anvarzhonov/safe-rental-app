package ru.anvarzhonov.sbrf.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ValidateUserCredentialsRequest extends BaseApiResponse {
    private String username;
    private String password;
}
