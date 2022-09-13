package Cart.Cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "cart")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    /*@ManyToOne
    private CartProduct cartPro;*/

    /*@ManyToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Product> product;

    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CartProduct> cartProducts = new ArrayList<>();*/

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartProduct> cartProductList;

    private String deliveryAddress;
    private Date createDate;
    private char status;


}
