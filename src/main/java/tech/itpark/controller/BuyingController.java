package tech.itpark.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.dto.BuyerDto;
import tech.itpark.dto.BuyingDto;
import tech.itpark.manager.BuyingManager;

import java.util.List;

@RestController
@RequestMapping("/buyings")
@RequiredArgsConstructor
public class BuyingController {
    private final BuyingManager manager;

    @GetMapping
    public List<BuyingDto> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public BuyingDto getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @PostMapping()
    public BuyingDto save(@RequestBody BuyingDto dto) {
        return manager.save(dto);
    }
}
