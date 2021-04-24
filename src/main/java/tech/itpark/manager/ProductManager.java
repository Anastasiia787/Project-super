package tech.itpark.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.itpark.exception.DataAccessException;
import tech.itpark.exception.NotFoundException;
import tech.itpark.dto.ProductDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductManager {
    private final DataSource dataSource;

    public List<ProductDto> getAll() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT id, name, price FROM products ORDER BY id LIMIT 50");
        ) {
            List<ProductDto> items = new ArrayList<>();
            while (rs.next()) {
                items.add(new ProductDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("price")
                ));

            }
            return items;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    public ProductDto getById(long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id, name, price FROM products WHERE id = ?");
        ) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ProductDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("price")
                );
            }
            throw new NotFoundException();
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }


    public ProductDto save(ProductDto item) {
        if (item.getId() == 0) {
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(
                            "INSERT INTO products(name, price) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            ) {
                int index = 0;
                stmt.setString(++index, item.getName());
                stmt.setInt(++index, item.getPrice());
                stmt.execute();

                try (ResultSet keys = stmt.getGeneratedKeys();) {
                    if (keys.next()) {
                        long id = keys.getLong(1);
                        return getById(1);
                    }
                    throw new DataAccessException("No keys generated");
                }

            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        }

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE products SET name = ?, price = ? WHERE id = ?");
        ) {
            int index = 0;
            stmt.setString(++index, item.getName());
            stmt.setInt(++index, item.getPrice());
            stmt.setLong(++index, item.getId());
            stmt.execute();

            return getById(item.getId());

        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    public ProductDto removeById(long id) {
        ProductDto item = getById(id);

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM products WHERE id = ?");
        ) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
        return item;
    }
}
