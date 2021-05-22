package tech.itpark.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyingDto {
    private long id;
    private long buyerId;
    private long productId;
    private String brand;
    private int quantity;
    private int price;
}
