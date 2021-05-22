package tech.itpark.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.dto.BuyerDto;
import tech.itpark.manager.BuyerManager;

import java.util.List;

@RestController
@RequestMapping("/buyers")
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerManager manager;

    @GetMapping
    public List<BuyerDto> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public BuyerDto getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @PostMapping()
    public BuyerDto save(@RequestBody BuyerDto dto) {
        return manager.save(dto);
    }

    @PutMapping("/{id}")
    public BuyerDto update(@PathVariable long id, @RequestBody BuyerDto dto) {
        dto.setId(id);
        return manager.update(dto);
    }
}
