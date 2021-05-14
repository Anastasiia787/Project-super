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

    @GetMapping("/{buyerId}")
    public BuyerDto getByBuyerId(@PathVariable long buyerId) {
        return manager.getByBuyerId(buyerId);
    }

    @PostMapping()
    public BuyerDto save(@RequestBody BuyerDto dto) {
        return manager.save(dto);
    }

    @PutMapping("/{buyerId}")
    public BuyerDto update(@RequestBody BuyerDto dto) {
        return manager.update(dto);

    }
}
