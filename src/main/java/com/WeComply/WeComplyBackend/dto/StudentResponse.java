package com.WeComply.WeComplyBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private String fullName;

    private String info;

    private Integer sanctionId;

    private String sanctionDescription;

}
