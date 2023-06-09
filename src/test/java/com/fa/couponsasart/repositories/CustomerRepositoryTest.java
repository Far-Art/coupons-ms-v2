package com.fa.couponsasart.repositories;

import com.fa.couponsasart.domain.entities.Customer;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    // TODO rollback annotation is not working
    @Autowired
    CustomersRepository<String> repo;

    @Test
    @Transactional
    @Rollback
    public void testSaveValid() {
        Customer cust = Customer.builder()
                .email("testsave@gmail.com")
                .password("Password123")
                .firstName("firstName")
                .lastName("lastName")
                .birthDay(LocalDate.of(2000, 1, 1))
                .build();

        Customer saved = repo.save(cust);
        repo.flush(); // flush is needed for validations to perform

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();

        repo.deleteById(saved.getId()); // TODO remove after fixing rollback
        repo.flush();
    }

    @Test
    @Transactional
    @Rollback
    public void testCustomerValidations() {
        Customer cust = Customer.builder()
                .email("BadEmail@gmail")
                .password("Pass")
                .middleName("")
                .created(LocalDateTime.now())
                .build();

        ConstraintViolationException validationException = null;
        try {
            repo.save(cust);
            repo.flush(); // flush is needed for validations to perform
        } catch (ConstraintViolationException e) {
            validationException = e;
        }

        assertThat(validationException).isNotNull();
        assertThat(validationException.getConstraintViolations().size()).isEqualTo(7);
    }
}
