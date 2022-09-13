package Cart.Cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "CartProduct")
@Table(name = "CartProduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProduct {
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "productCa", cascade = CascadeType.ALL)
//    private List<Product> productCa;
////    private Product product;
//
//    @OneToMany(mappedBy = "cartPro", cascade = CascadeType.ALL)
//    private List<Cart> cartPro;
    /*@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartId")
    private Cart cart;*/

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "quantity")
    private Integer quantity;
}
