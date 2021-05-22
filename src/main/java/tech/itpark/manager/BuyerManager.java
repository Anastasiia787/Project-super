package tech.itpark.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.dto.BuyerDto;
import tech.itpark.mapper.BuyerRowMapper;


import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BuyerManager {
    private final NamedParameterJdbcTemplate template;
    private final BuyerRowMapper rowMapper = new BuyerRowMapper();

    public List<BuyerDto> getAll() {
        return template.query(
                "SELECT id, name, avatar, gender, age, phone_number " +
                        "FROM buyers ORDER BY id",
                rowMapper
        );
    }

    public BuyerDto getById(long id) {
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
        long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        return getById(id);
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
        return dto;
    }
}
