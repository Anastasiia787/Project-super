package tech.itpark.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.manager.ProductManager;
import tech.itpark.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductManager manager;


    @RequestMapping
    public List<ProductDto> getAll() {
        return manager.getAll();
    }

    @RequestMapping("/{id}")
    public ProductDto getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @RequestMapping("/{id}/save")
    public ProductDto save(
            @PathVariable long id,
            @RequestParam String name,
            @RequestParam int price
    ) {
        return manager.save(new ProductDto(id, name, price));
    }

    @RequestMapping("/{id}/remove")
    public ProductDto removeById(@PathVariable long id) {
        return manager.removeById(id);
    }
}
