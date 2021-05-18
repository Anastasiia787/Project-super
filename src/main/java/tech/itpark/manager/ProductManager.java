package tech.itpark.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.dto.ProductDto;
import tech.itpark.mapper.ProductRowMapper;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProductManager {
    private final NamedParameterJdbcTemplate template;
    private final ProductRowMapper rowMapper = new ProductRowMapper();

    public List<ProductDto> getAll() {
        return template.query(
                "SELECT id, model, brand, wheel_diameter, price, quantity deleted FROM products ORDER BY id",
                rowMapper
        );
    }

    public ProductDto getById(long id) {
        return template.queryForObject(
                "SELECT id, model, brand, wheel_diameter, price, quantity, deleted FROM products WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public ProductDto save(ProductDto dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                "INSERT INTO products(model, brand, wheel_diameter, price, quantity) VALUES (:model, :brand, :wheel_diameter, :price, :quantity)",
                new MapSqlParameterSource(Map.of(
                        "model", dto.getModel(),
                        "brand", dto.getBrand(),
                        "wheel_diameter", dto.getWheelDiameter(),
                        "price", dto.getPrice(),
                        "quantity", dto.getQuantity()
                )),
                keyHolder
        );
        return dto;
    }

    public ProductDto update(ProductDto dto) {
        template.update(
                "UPDATE products SET model = :model, brand = :brand, wheel_diameter = :wheel_diameter, price = :price, quantity = :quantity WHERE id = :id",
                Map.of(
                        "id", dto.getId(),
                        "model", dto.getModel(),
                        "brand", dto.getBrand(),
                        "wheel_diameter", dto.getWheelDiameter(),
                        "price", dto.getPrice(),
                        "quantity", dto.getQuantity()
                )
        );
        return getById(dto.getId());
    }

    public List<ProductDto> search(String model) {
        return template.query(
                "SELECT id, model, brand, wheel_diameter, price, quantity, deleted FROM products WHERE model = :model",
                Map.of("model", model),
                rowMapper
        );
    }

    public boolean removeById(long id) {
        ProductDto dto = getById(id);
        template.update(
                "UPDATE products SET deleted = true WHERE id = :id",
                Map.of("id", dto.getId())
        );
        return true;
    }
}
