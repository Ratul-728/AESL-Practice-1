package Cart.Cart.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(unique = true, nullable = false)
    private Long id;

    private String productName;

    private int quantity;

    private double price;

    private String productDetails;

    private double rating;

    @ManyToOne
    private Shop shop;

    /*@ManyToOne
    private CartProduct productCa;*/

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartProduct> cartProductList;

    /*@ManyToMany
    @JoinTable(
            name = "cart_info",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    private List<Cart> cart;*/

    /*@OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CartProduct> cartProducts = new ArrayList<>();*/

    private String productCreateDate;

    private char productStatus;

}
