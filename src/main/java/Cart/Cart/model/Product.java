package Cart.Cart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue

    private Long id;

    private String productName;

    private int quantity;

    private double price;

    private String productDetails;

    private double rating;

    @ManyToOne
    private Shop shop;

    @ManyToMany
    @JoinTable(
            name = "cart_info",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    private List<Cart> cart;

    private String productCreateDate;

    private char productStatus;

}
