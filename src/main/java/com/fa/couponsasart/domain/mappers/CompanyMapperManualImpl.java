package com.fa.couponsasart.domain.mappers;

import com.fa.couponsasart.domain.dto.CompanyDTO;
import com.fa.couponsasart.domain.entities.Company;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CompanyMapperManualImpl implements CompanyMapper {
    @Override
    public Company toEntity(CompanyDTO dto) {
        if (dto == null) {
            return null;
        }

        return Company.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .created(dto.getCreated())
                .updated(dto.getUpdated())
                .build();
    }

    @Override
    public CompanyDTO toDto(Company company) {
        if (company == null) {
            return null;
        }

        return CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .email(company.getEmail())
                .role(company.getRole())
                .created(company.getCreated())
                .updated(company.getUpdated())
                .build();
    }
}
