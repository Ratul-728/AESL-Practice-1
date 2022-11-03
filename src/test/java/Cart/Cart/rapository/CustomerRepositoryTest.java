package Cart.Cart.rapository;

import Cart.Cart.model.Customer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckUpdateCustomer() {
        String date1 ="01-Jan-2017";
        String date2 = "02-Feb-2017";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        LocalDate  d1 = LocalDate.parse(date1, df);
        LocalDate  d2 = LocalDate.parse(date2, df);

        //Given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCustomerName("Ahad");
        customer.setPassword("123456");
        customer.setCustomerEmail("a@gmail.com");
        customer.setCustomerContact("016666");
        customer.setCustomerAddress("Motijheel");
        customer.setCustomerDob(d1);
        //customer.setCustomerCreateDate(d1.atStartOfDay());
        customer.setCustomerStatus("1");
        //System.out.println(customer.getCustomerAddress());
        //System.out.println(customer.getCustomerContact());

        underTest.save(customer);

        //When
        boolean exists = underTest.existsById(1L);
        //Then
        assertThat(exists).isTrue();
    }
    @Test
    void itCustomerDoesNotExistById() {
        boolean exists = underTest.existsById(1L);
        assertThat(exists).isFalse();
    }
}