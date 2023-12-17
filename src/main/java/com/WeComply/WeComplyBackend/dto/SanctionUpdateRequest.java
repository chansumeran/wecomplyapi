package com.WeComply.WeComplyBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanctionUpdateRequest {
    private Integer sanctionId;
    private Integer newTrigger;
    private String newDescription;
}
