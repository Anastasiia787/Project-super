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

    public BuyerDto getByBuyerId(long id) {
        return template.queryForObject(
                "SELECT id, name, avatar, gender, age, phone_number FROM buyers WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public BuyerDto save(BuyerDto dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                "INSERT INTO buyers(name, avatar, gender, age, phone_number) VALUES (:name, :avatar, :gender, :age, :phone_number)",
                new MapSqlParameterSource(Map.of(
                        "name", dto.getName(),
                        "avatar", dto.getAvatar(),
                        "gender", dto.getGender(),
                        "age", dto.getAge(),
                        "phone_number", dto.getPhoneNumber()
                )),
                keyHolder
        );
        return dto;
    }

    public BuyerDto update(BuyerDto dto) {
        template.update(
                "UPDATE buyers SET name = :name, avatar = :avatar, age = :age, phone_number = :phone_number WHERE id = :id",
                Map.of(
                        "id", dto.getId(),
                        "name", dto.getName(),
                        "avatar", dto.getAvatar(),
                        "age", dto.getAge(),
                        "phone_number", dto.getPhoneNumber()
                )
        );
        return getByBuyerId(dto.getId());
    }

}
