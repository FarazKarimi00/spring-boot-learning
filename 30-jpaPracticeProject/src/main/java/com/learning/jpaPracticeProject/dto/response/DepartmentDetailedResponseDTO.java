package com.learning.jpaPracticeProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDetailedResponseDTO {
    private Long id;
    private String name;
    private String code;
    private String description;
    private List<StudentSummaryResponseDTO> students = new ArrayList<>();
}
