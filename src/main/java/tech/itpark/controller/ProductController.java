package tech.itpark.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.manager.ProductManager;
import tech.itpark.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductManager manager;


    @GetMapping
    public List<ProductDto> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @GetMapping("/search")
    public List<ProductDto> search(@RequestParam String model) {
        return manager.search(model);
   }

    @PostMapping()
    public ProductDto save(@RequestBody ProductDto dto) {
        return manager.save(dto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@RequestBody ProductDto dto) {
        return manager.update(dto);
    }

    @DeleteMapping("/{id}")
    public boolean removeById(@PathVariable long id) {
        manager.removeById(id);
        return true;
    }
}
