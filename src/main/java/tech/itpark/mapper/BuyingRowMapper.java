package tech.itpark.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.dto.BuyingDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyingRowMapper implements RowMapper<BuyingDto> {
    public BuyingDto mapRow(ResultSet rs, int rowNumb) throws SQLException {
        return new BuyingDto(
                rs.getLong("id"),
                rs.getLong("buyerId"),
                rs.getLong("productId"),
                rs.getString("brand"),
                rs.getInt("quantity"),
                rs.getInt("price")
        );
    }
}
