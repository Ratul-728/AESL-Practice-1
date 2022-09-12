package Cart.Cart.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Customer {
    @Id
    //need to learn
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long cutomerId;

    private String customerName;

    private String password;

    private String customerEmail;

    private String customerContact;

    private String customerAddress;

    private String customerDob;

    private String customerCreateDate;

    private String customerStatus;

}
