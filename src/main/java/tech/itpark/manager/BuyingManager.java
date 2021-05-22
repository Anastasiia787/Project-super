package tech.itpark.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.dto.BuyerDto;
import tech.itpark.dto.BuyingDto;
import tech.itpark.mapper.BuyingRowMapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BuyingManager {
    private final NamedParameterJdbcTemplate template;
    private final BuyingRowMapper rowMapper = new BuyingRowMapper();

    public List<BuyingDto> getAll() {
        return template.query(
                "SELECT id, buyer_id, product_id, brand, quantity, price " +
                        "FROM buyings ORDER BY id",
                rowMapper
        );
    }

    public BuyingDto getById(long id) {
        return template.queryForObject(
                "SELECT id, buyer_id, product_id, brand, quantity, price " +
                        "FROM buyings WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public BuyingDto save(BuyingDto dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                "INSERT INTO buyings(buyer_id, product_id, brand, quantity, price) " +
                        "VALUES (:buyer_id, :product_id, :brand, :quantity, :price)",
                new MapSqlParameterSource(Map.of(
                        "buyer_id", dto.getBuyerId(),
                        "product_id", dto.getProductId(),
                        "brand", dto.getBrand(),
                        "quantity", dto.getQuantity(),
                        "price", dto.getPrice()
                )),
                keyHolder
        );
        long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        return getById(id);
    }
}
