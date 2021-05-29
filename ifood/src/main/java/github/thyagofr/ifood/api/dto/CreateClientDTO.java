package github.thyagofr.ifood.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CreateClientDTO implements Serializable{

    @NotBlank(message = "name must be provided")
    @Size(min = 2)
    private String name;

    @Email
    private String email;

    private String phone;

}
