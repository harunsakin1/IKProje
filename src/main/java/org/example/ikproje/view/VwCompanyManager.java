package org.example.ikproje.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ikproje.entity.enums.EUserDepartmentType;
import org.example.ikproje.entity.enums.EUserRole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VwCompanyManager {



    //user
    Long id;
    Long companyId;
    String firstName;
    String lastName;
    String email;
    String companyName;
    String phone;
    String avatarUrl;
    EUserRole userRole;
    //userDetails
    String region;
    String city;
    String district;
    String neighbourhood;
    String street;
    String postalCode;
    String aptNumber;
    //userDetails
    LocalDate hireDate;
    String tcNo;
    String sgkNo;
    LocalDate birthDate;


    //başka şeyler de eklenebilir



}
