package com.WeComply.WeComplyBackend.controller;

import com.WeComply.WeComplyBackend.dto.SanctionUpdateRequest;
import com.WeComply.WeComplyBackend.entity.Sanction;
import com.WeComply.WeComplyBackend.service.SanctionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class SanctionController {

    private final SanctionServiceImpl sanctionService;

    @PutMapping("/update-descriptions")
    public void updateSanctionDescription(
            @RequestBody List<SanctionUpdateRequest> updateRequests) {
        sanctionService.updateSanctionDescriptions(updateRequests);
    }

    @PutMapping("/update-triggers")
    public void updateSanctionTrigger(
            @RequestBody List<SanctionUpdateRequest> updateRequests) {
        sanctionService.updateSanctionTriggers(updateRequests);
    }

}
