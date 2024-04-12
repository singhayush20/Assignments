package org.ayushsingh.jdbc_jpa_demo.dto.department;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentCreateDto {
    private String name;

    private String technology;

    private String address;

    private Long contact;
}
