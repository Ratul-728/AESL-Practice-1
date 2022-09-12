package Cart.Cart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Shop {
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

    private Long shopId;

    private String shopName;

    private String shopDetails;

    private String shopAddress;

    private String shopContact;

    private String shopEmail;

    private String shopCreateDate;

    private char shopStatus;

//    @OneToMany(mappedBy = "shopId", cascade = CascadeType.ALL)
//    private List<Product> productId;
//
//    @OneToMany(mappedBy = "shopName", cascade = CascadeType.ALL)
//    private List<Product> productName;

    @OneToMany(mappedBy = "shopId", cascade = CascadeType.ALL)
    private List<Product> products;
}
