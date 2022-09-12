package Cart.Cart.rapository;

import Cart.Cart.dto.CustomerDto;
import Cart.Cart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(nativeQuery = true, value = "update customer set customer_name = ?2, customer_dob = ?3, customer_email = ?4, customer_contact = ?5, customer_address = ?6 where id = ?1")
    int updateCustomer(Long customerId, String customerName, String customerDob, String customerEmail, String customerContact, String customerAddress);
    /*@Query(nativeQuery = true, value = "SELECT * FROM customer")
    Optional<Customer> findByIdEmail(@Param("email") String email,
                                     @Param("pass") String pass);*/
}
