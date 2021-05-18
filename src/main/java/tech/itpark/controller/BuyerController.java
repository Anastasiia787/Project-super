package tech.itpark.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.dto.BuyerDto;
import tech.itpark.manager.BuyerManager;

@RestController
@RequestMapping("/buyers")
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerManager manager;

    @GetMapping("/{id}")
    public BuyerDto getByBuyerId(@PathVariable long id) {
        return manager.getByBuyerId(id);
    }

    @PostMapping()
    public BuyerDto save(@RequestBody BuyerDto dto) {
        return manager.save(dto);
    }

    @PutMapping()
    public BuyerDto update(@RequestBody BuyerDto dto) {
        return manager.update(dto);
    }
}
