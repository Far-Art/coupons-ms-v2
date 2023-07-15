package com.fa.couponsasart.domain.mappers;

import com.fa.couponsasart.domain.dto.CustomerDTO;
import com.fa.couponsasart.domain.entities.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CustomerMapperManualImpl implements CustomerMapper {


    @Override
    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }

        return Customer.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .middleName(dto.getMiddleName())
                .birthDay(dto.getBirthDay())
                .created(dto.getCreated())
                .updated(dto.getUpdated())
                .build();
    }

    @Override
    public CustomerDTO toDto(Customer customer) {
        if (customer == null) {
            return null;
        }

        return CustomerDTO.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .role(customer.getRole())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .middleName(customer.getMiddleName())
                .birthDay(customer.getBirthDay())
                .created(customer.getCreated())
                .updated(customer.getUpdated())
                .build();
    }
}
