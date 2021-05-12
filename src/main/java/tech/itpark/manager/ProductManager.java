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

/**
 * Product manager.
 */
@Component
@RequiredArgsConstructor
public class ProductManager {
    private final NamedParameterJdbcTemplate template;
    private final ProductRowMapper rowMapper = new ProductRowMapper();

    /**
     * Return all products.
     *
     * @return products
     */
    public List<ProductDto> getAll() {
        return template.query(
                "SELECT id, name, price, quantity, deleted FROM products ORDER BY id",
                rowMapper
        );
    }

    /**
     * Return product by Id.
     *
     * @param id product id
     * @return product
     */
    public ProductDto getById(long id) {
        return template.queryForObject(
                "SELECT id, name, price, quantity, deleted FROM products WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    /**
     * Save product.
     *
     * @param dto product
     * @return product
     */
    public ProductDto save(ProductDto dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                "INSERT INTO products(name, price, quantity) VALUES (:name, :price, :quantity)",
                new MapSqlParameterSource(Map.of(
                        "name", dto.getName(),
                        "price", dto.getPrice(),
                        "quantity", dto.getQuantity()
                )),
                keyHolder
        );
        return dto;
    }

    /**
     * Update product.
     *
     * @param dto product
     * @return product
     */
    public ProductDto update(ProductDto dto) {
        template.update(
                "UPDATE products SET name = :name, price = :price, quantity = :quantity WHERE id = :id",
                Map.of(
                        "id", dto.getId(),
                        "name", dto.getName(),
                        "price", dto.getPrice(),
                        "quantity", dto.getQuantity()
                )
        );
        return getById(dto.getId());
    }

    public List<ProductDto> search(String name) {
        return template.query(
                "SELECT id, name, price, quantity, deleted FROM products WHERE name = :name",
                Map.of("name", name),
                rowMapper
        );
    }

    /**
     * Delete product by id.
     *
     * @param id product id
     * @return deleting success
     */
    public boolean removeById(long id) {
        ProductDto dto = getById(id);
        template.update(
                "UPDATE products SET deleted = true WHERE id = :id",
                Map.of("id", dto.getId())
        );
        return true;
    }
}
