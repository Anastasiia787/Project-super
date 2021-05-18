package tech.itpark.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.dto.BuyingDto;
import tech.itpark.mapper.BuyingRowMapper;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BuyingManager {
    private final NamedParameterJdbcTemplate template;
    private final BuyingRowMapper rowMapper = new BuyingRowMapper();

    public BuyingDto getByBuyingId(long id) {
        return template.queryForObject(
                "SELECT id, buyer_id, product_id, brand, quantity, price FROM buyings WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public BuyingDto save(BuyingDto dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                "INSERT INTO buyings(buyer_id, product_id, brand, quantity, price) VALUES (:buyer_id, :product_id, :brand, :quantity, :price)",
                new MapSqlParameterSource(Map.of(
                        "buyer_id", dto.getBuyerId(),
                        "product_id", dto.getProductId(),
                        "model", dto.getBrand(),
                        "quantity", dto.getQuantity(),
                        "price", dto.getPrice()
                )),
                keyHolder
        );
        return dto;
    }
}
