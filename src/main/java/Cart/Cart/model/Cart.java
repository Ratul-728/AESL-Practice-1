package Cart.Cart.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "cart")
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Product> product;

    private String deliveryAddress;
    private Date createDate;
    private char status;


}
