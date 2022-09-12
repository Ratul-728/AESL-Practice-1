package Cart.Cart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Product {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long productId;

    private String productName;

    private int quantity;

    private double price;

    private String productDetails;

    private double rating;

//    @ManyToOne
//    private Shop shopId;
//
//    @ManyToOne
//    private Shop shopName;

    private String productCreateDate;

    private char productStatus;

    @ManyToOne
//    @JoinColumns({
            @JoinColumn(name = "shopId")
            //@JoinColumn(name = "shopName")
//    })
    private Shop shop;
}
