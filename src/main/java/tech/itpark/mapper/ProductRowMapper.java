package tech.itpark.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.dto.ProductDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductDto> {
    public ProductDto mapRow(ResultSet rs, int rowNumb) throws SQLException {
        return new ProductDto(
                rs.getLong("id"),
                rs.getString("picture"),
                rs.getString("model"),
                rs.getString("brand"),
                rs.getInt("wheel_diameter"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getBoolean("deleted")
        );
    }
}
