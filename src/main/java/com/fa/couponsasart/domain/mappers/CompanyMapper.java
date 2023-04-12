package com.fa.couponsasart.domain.mappers;

import com.fa.couponsasart.domain.dto.CompanyDTO;
import com.fa.couponsasart.domain.entities.Company;

// TODO i have a problem with lombok and inheritance in mapstruct, try to solve later
//@Mapper
public interface CompanyMapper {

    //    @BeanMapping(builder = @Builder(disableBuilder = true))
    Company toEntity(CompanyDTO dto);

    //    @BeanMapping(builder = @Builder(disableBuilder = true))
//    @SubclassMapping(target = CompanyDTO.class, source = Company.class)
    CompanyDTO toDto(Company company);
}
