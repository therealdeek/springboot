package form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class CreateUserForm {

    @NotEmpty(message = "Email is required.")
    @Length(max = 200, message = "Email must be less than 200 characters.")
    private String email;

    @NotEmpty(message = "password is required.")
    @Pattern(regexp = "^[a-z,A-Z,0-9,\\D,\\d]+$", message = "Password can only contain lowercase, uppercase, and special characters")
    @Length(min = 8, message = "Password must be longer than 8 characters.")
    @Length(max = 25, message = "Password must be shorter than 25 characters.")

    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String address;

    @Length(max = 30, message = "City must be 30 characters or less.")
    private String city;

    @Length(max = 2, message = "State must be 2 characters.")
    private String state;

    @Length(max = 5, message = "Zip must be 5 characters.")
    private String zip;

    @Length(max = 10, message = "Phone must be 10 characters or less.")
    private String phone;
}
