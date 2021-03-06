package tech.itpark.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyerDto {
    private long id;
    private String name;
    private String avatar = "noavatar.jpg";
    private String gender;
    private int age;
    private String phoneNumber;
}
