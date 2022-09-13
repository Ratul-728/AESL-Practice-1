package Cart.Cart.service;

import Cart.Cart.dto.ProductDto;
import Cart.Cart.model.Product;
import Cart.Cart.model.Shop;
import Cart.Cart.rapository.ProductRepository;
import Cart.Cart.rapository.ShopRepository;
import Cart.Cart.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;

    private final Response response = new Response();

    public ProductService(ProductRepository productRepository, ShopRepository shopRepository) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
    }

    public ResponseEntity<?> addProduct(ProductDto productDto){
        Product product = new Product();

        product.setProductName(productDto.getProductNameDto());
        product.setProductDetails(productDto.getProductDetailsDto());
        product.setPrice(productDto.getPriceDto());
        product.setQuantity(productDto.getQuantityDto());
        product.setRating(productDto.getRatingDto());
        product.setProductStatus('1');

        Optional<Shop> shop = shopRepository.findById((long) productDto.getShopIdDto());

        if(shop.isEmpty()){
            response.setMessage("Shop not found!");
            response.setStatus("BAD_REQUEST");
            response.setSuccessData(null);
            response.setErrorData(product);
            return ResponseEntity.badRequest().body(response);

        }else{
            product.setShop(shop.get());
            try{
                productRepository.save(product);
            }catch(Exception e){
                e.printStackTrace();
                response.setMessage(e.getMessage());
                response.setStatus("BAD_REQUEST");
                response.setSuccessData(null);
                response.setErrorData(product);
                return ResponseEntity.badRequest().body(response);
            }

            response.setMessage("Product add successfully");
            response.setStatus("GOOD_REQUEST");
            response.setSuccessData(product);
            response.setErrorData(null);
            return ResponseEntity.accepted().body(response);
        }

    }
}
