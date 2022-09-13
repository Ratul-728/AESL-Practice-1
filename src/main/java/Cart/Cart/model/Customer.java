package Cart.Cart.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String customerName;

    private String password;

    private String customerEmail;

    private String customerContact;

    private String customerAddress;

    private LocalDate customerDob;

    private LocalDateTime customerCreateDate;

    private String customerStatus;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Cart> cart;


}
