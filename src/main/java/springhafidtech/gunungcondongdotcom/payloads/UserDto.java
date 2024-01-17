package springhafidtech.gunungcondongdotcom.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters!")
    private String firstName;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters!")
    private String lastName;

    @Email(message = "Email address is not valid !")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 characters")
    private String password;

    private String imageName;

    private Set<RoleDto> roles = new HashSet<>();
}