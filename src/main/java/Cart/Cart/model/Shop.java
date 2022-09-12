package Cart.Cart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shop")
@Data
public class Shop {
    @Id
    @GeneratedValue

    private Long id;

    @Column(name = "shopName", nullable = false)
    private String shopName;

    private String shopDetails;

    private String shopAddress;

    private String shopContact;

    private String shopEmail;

    private String shopCreateDate;

    private char shopStatus;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Product> products;

}
