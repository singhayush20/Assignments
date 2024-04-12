package org.ayushsingh.jdbc_jpa_demo.dto.project;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCreateDto {
    private String title;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}
