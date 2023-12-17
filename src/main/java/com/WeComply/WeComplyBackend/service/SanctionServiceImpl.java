package com.WeComply.WeComplyBackend.service;

import com.WeComply.WeComplyBackend.dto.SanctionUpdateRequest;
import com.WeComply.WeComplyBackend.entity.Sanction;
import com.WeComply.WeComplyBackend.repository.SanctionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SanctionServiceImpl implements SanctionService {

    private final SanctionRepository sanctionRepository;

    @Override
    public void updateSanctionDescriptions(List<SanctionUpdateRequest> updateRequests) {

        for (SanctionUpdateRequest request : updateRequests) {
            Sanction existingSanction = sanctionRepository.findById(request.getSanctionId())
                    .orElseThrow(() -> new EntityNotFoundException("Sanction not found with id: " + request.getSanctionId()));

            existingSanction.setDescription(request.getNewDescription());
            sanctionRepository.save(existingSanction);
        }
    }

    @Override
    public void updateSanctionTriggers(List<SanctionUpdateRequest> updateRequests) {

        for (SanctionUpdateRequest request : updateRequests) {
            Sanction existingSanction = sanctionRepository.findById(request.getSanctionId())
                    .orElseThrow(() -> new EntityNotFoundException("Sanction not found with id: " + request.getSanctionId()));

            existingSanction.setTriggerValue(request.getNewTrigger());
            sanctionRepository.save(existingSanction);
        }
    }
}
