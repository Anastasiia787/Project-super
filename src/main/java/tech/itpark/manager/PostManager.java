package tech.itpark.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import tech.itpark.dto.PostDto;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PostManager {
  private final NamedParameterJdbcTemplate jdbcTemplate;

  public List<PostDto> getAll() {
    return jdbcTemplate.query(
        // language=SQL
        "SELECT id, content, media FROM posts",
        (rs, rowNum) -> new PostDto(
            rs.getLong("id"),
            rs.getString("content"),
            rs.getString("media")
        )
    );
  }

  public void save(PostDto post) {

    jdbcTemplate.update(

        "INSERT INTO posts(content, media) VALUES (:content, :media)", // named parameter - вместо ? подставляем псевдонимы :content

        Map.of(
            "content", post.getContent(),
            "media", post.getMedia()
        )
    );
  }
}
