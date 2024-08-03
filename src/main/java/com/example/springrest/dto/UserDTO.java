package com.example.springrest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {
    private Integer id;
    private String firstName;
    @NotNull(message = "Last name Must not be null")
    private String lastName;
    @NotNull(message = "Price Must not be null")
    @Min(value = 1,message = "Price should not be less than 0")
    @Max(value = 100,message = "Price should not be grater than 100")
    private Integer price;

}
