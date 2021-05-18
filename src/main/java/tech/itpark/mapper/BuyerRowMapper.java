package tech.itpark.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.dto.BuyerDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerRowMapper implements RowMapper<BuyerDto> {
    public BuyerDto mapRow(ResultSet rs, int rowNumb) throws SQLException {
        return new BuyerDto(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("avatar"),
                rs.getString("gender"),
                rs.getInt("age"),
                rs.getString("phone_number")
        );
    }
}
