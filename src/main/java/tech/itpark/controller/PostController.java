package tech.itpark.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.dto.PostDto;
import tech.itpark.manager.PostManager;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
  private final PostManager manager;

  @GetMapping
  public List<PostDto> getAll() {
    return manager.getAll();
  }

  @PostMapping
  public void save(@RequestBody PostDto post) {
    manager.save(post);
  }
}
