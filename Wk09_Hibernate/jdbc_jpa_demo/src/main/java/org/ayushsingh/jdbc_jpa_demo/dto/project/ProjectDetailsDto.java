package org.ayushsingh.jdbc_jpa_demo.dto.project;

import java.time.LocalDate;
import lombok.*;

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
