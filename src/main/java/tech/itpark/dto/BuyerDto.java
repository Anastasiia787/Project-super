package tech.itpark.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyerDto {
    private long buyerId;
    private String buyerName;
    private String genderPerson;
    private int year;
    private String phoneNumber;
}
