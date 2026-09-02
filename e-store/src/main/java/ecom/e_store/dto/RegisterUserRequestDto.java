package ecom.e_store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequestDto {

    @NotBlank(message = "Name cannot be blank")
    @Size(min=5, max=30,message="The length of the name should be 5 and 30")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message="Email should be in a valid format")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number should be exact 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Password is required")
    @Size(min=4, max = 20, message = "Password length must be between 8 and 20 characters")
    private String password;
}
