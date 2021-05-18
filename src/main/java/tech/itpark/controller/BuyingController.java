package tech.itpark.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.dto.BuyingDto;
import tech.itpark.manager.BuyingManager;

@RestController
@RequestMapping("/buyings")
@RequiredArgsConstructor
public class BuyingController {
    private final BuyingManager manager;

    @GetMapping("/{id}")
    public BuyingDto getByBuyingId(@PathVariable long id) {
        return manager.getByBuyingId(id);
    }

    @PostMapping()
    public BuyingDto save(@RequestBody BuyingDto dto) {
        return manager.save(dto);
    }
}
