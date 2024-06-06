package org.ayushsingh.jdbc_jpa_demo.dto.project;

import java.time.LocalDate;
import lombok.*;


/**
 * DTO for details of {@link org.ayushsingh.jdbc_jpa_demo.entity.Project}.
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
public class ProjectDetailsDto {

    private String projectId;
    private String title;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}
