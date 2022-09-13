package Cart.Cart.controller;

import Cart.Cart.dto.ShopDto;
import Cart.Cart.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/create-shop")
    private ResponseEntity<?> createShop(@RequestBody ShopDto shopDto){
        return shopService.createShop(shopDto);
    }
}
