package org.ayushsingh.jdbc_jpa_demo.dto.department;

import lombok.*;


/**
 * DTO for details of {@link org.ayushsingh.jdbc_jpa_demo.entity.Department}.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDetailsDto {

    private Long departmentId;

    private String name;

    private String technology;

    private String address;

    private Long contact;
}
