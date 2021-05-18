package tech.itpark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private long id;
    private String model;
    private String brand;
    private int wheelDiameter;
    private int price;
    private int quantity;
    private boolean deleted;
}
