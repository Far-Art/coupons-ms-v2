package com.fa.couponsasart.domain.mappers;

import com.fa.couponsasart.domain.dto.CustomerDTO;
import com.fa.couponsasart.domain.entities.Customer;

// TODO i have a problem with lombok and inheritance in mapstruct, try to solve later
//@Mapper
public interface CustomerMapper {

    //    @BeanMapping(builder = @Builder(disableBuilder = true))
    Customer toEntity(CustomerDTO dto);

    //    @BeanMapping(builder = @Builder(disableBuilder = true))
//    @SubclassMapping(target = CustomerDTO.class, source = Customer.class)
    CustomerDTO toDto(Customer customer);
}
