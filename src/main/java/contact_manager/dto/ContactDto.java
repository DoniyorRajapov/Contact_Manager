package contact_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContactDto {
    private UUID id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
    private String name;

    @Size(max = 25, message = "Surname must not exceed 25 characters")
    private String surname;

    @NotBlank(message = "Phone cannot be blank")
    @Size(min = 12, max = 12, message = "Phone must be exactly 12 characters")
    private String phone;
}