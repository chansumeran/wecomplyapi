package com.WeComply.WeComplyBackend.service;

import com.WeComply.WeComplyBackend.dto.SanctionUpdateRequest;
import com.WeComply.WeComplyBackend.entity.Sanction;

import java.util.List;

public interface SanctionService {
    void updateSanctionDescriptions(List<SanctionUpdateRequest> updateRequests);

    void updateSanctionTriggers(List<SanctionUpdateRequest> updateRequests);
}
