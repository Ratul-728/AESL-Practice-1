package Cart.Cart.service;

import Cart.Cart.dto.ShopDto;
import Cart.Cart.model.Shop;
import Cart.Cart.rapository.ShopRepository;
import Cart.Cart.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    private final Response response = new Response();

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public ResponseEntity<?> createShop(ShopDto shopDto){
        Shop shop = new Shop();

        shop.setShopAddress(shopDto.getShopAddressDto());
        shop.setShopContact(shopDto.getShopContactDto());
        shop.setShopDetails(shopDto.getShopDetailsDto());
        shop.setShopEmail(shopDto.getShopEmailDto());
        shop.setShopName(shopDto.getShopNameDto());
        shop.setShopCreateDate(LocalDateTime.now());
        shop.setShopStatus('1');

        try{
            shopRepository.save(shop);
        }catch(Exception e){
            response.setMessage(e.getMessage());
            response.setStatus("BAD_REQUEST");
            response.setSuccessData(null);
            response.setErrorData(shop);
            return ResponseEntity.badRequest().body(response);
        }

        response.setMessage("Shop create successfully");
        response.setStatus("GOOD_REQUEST");
        response.setSuccessData(shop);
        response.setErrorData(null);
        return ResponseEntity.accepted().body(response);
    }
}
