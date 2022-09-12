package Cart.Cart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Customer {
    @Id
    @GeneratedValue

    private Long id;

    private String customerName;

    private String password;

    private String customerEmail;

    private String customerContact;

    private String customerAddress;

    private String customerDob;

    private String customerCreateDate;

    private String customerStatus;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Cart> cart;

}
