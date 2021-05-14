package tech.itpark.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.dto.BuyerDto;


import java.sql.ResultSet;
import java.sql.SQLException;


public class BuyerRowMapper implements RowMapper<BuyerDto> {
    public BuyerDto mapRow(ResultSet rs, int rowNumb) throws SQLException {
        return new BuyerDto(
                rs.getLong("buyer_id"),
                rs.getString("buyer_name"),
                rs.getString("gender_person"),
                rs.getInt("year"),
                rs.getLong("phone_number")
        );
    }
}
