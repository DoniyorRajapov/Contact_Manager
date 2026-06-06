package contact_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProfileDto {

    private UUID id;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 5, max = 25, message = "Username must be between 5 and 25 characters")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 25, message = "Password must be between 8 and 25 characters")
    private String password;
}