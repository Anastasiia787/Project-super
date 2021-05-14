package tech.itpark.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.dto.BuyerDto;
import tech.itpark.mapper.BuyerRowMapper;


import java.util.Map;

@Component
@RequiredArgsConstructor
public class BuyerManager {
    private final NamedParameterJdbcTemplate template;
    private final BuyerRowMapper rowMapper = new BuyerRowMapper();

    public BuyerDto getByBuyerId(long buyerId) {
        return template.queryForObject(
                "SELECT buyer_id, buyer_name, gender_person, year, phone_number FROM buyers WHERE buyer_id = :buyer_id",
                Map.of("buyer_id", buyerId),
                rowMapper
        );
    }

    public BuyerDto save(BuyerDto dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                "INSERT INTO buyers(buyer_name, gender_person, year, phone_number) VALUES (:buyer_name, :gender_person, :year, :phone_number)",
                new MapSqlParameterSource(Map.of(
                        "buyer_name", dto.getBuyerName(),
                        "gender_person", dto.getGenderPerson(),
                        "year", dto.getYear(),
                        "phone_number", dto.getPhoneNumber()

                )),
                keyHolder
        );
        return dto;
    }

    public BuyerDto update(BuyerDto dto) {
        template.update(
                "UPDATE buyers SET buyer_name = :buyer_name, year = :year, phone_number = :phone_number WHERE buyer_id = :buyer_id",
                Map.of(
                        "buyer_id", dto.getBuyerId(),
                        "buyer_name", dto.getBuyerName(),
                        "year", dto.getYear(),
                        "phone_number", dto.getPhoneNumber()
                )
        );
        return getByBuyerId(dto.getBuyerId());
    }

}
