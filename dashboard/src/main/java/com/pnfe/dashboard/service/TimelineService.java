package com.pnfe.dashboard.service;

import com.pnfe.dashboard.dto.Amount;
import com.pnfe.dashboard.dto.OperationView;
import com.pnfe.dashboard.entity.OperationEntity;
import com.pnfe.dashboard.repository.OperationsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimelineService {

    @Autowired
    OperationsRepository operationsRepository;

    public List<OperationView> getOperations(String cardId) {
        List<OperationEntity> operationEntities = operationsRepository.findByCardId(cardId);
        List<OperationView> operationViews = operationEntities.stream().map(operationEntity -> {
            OperationView operationView = new OperationView();

            Amount amount = new Amount();
            amount.setAmount(operationEntity.getAmount());
            amount.setTaxPercent(getTaxPercentage(operationEntity.getCreditType()));

            if (amount.getTaxPercent() != 0.0) {
                Long taxPercent = new Double(amount.getTaxPercent()).longValue();
                Long taxAmount = ((operationEntity.getAmount()) / 100 * taxPercent);
                amount.setTaxAmount(taxAmount);
            }
            try {
                BeanUtils.copyProperties(operationEntity, operationView);
            } catch (Exception e) {
                e.printStackTrace();
            }
            operationView.setOperationAmount(amount);
            return operationView;
        }).collect(Collectors.toList());
        return operationViews;
    }

    private double getTaxPercentage(String creditType) {
        if (creditType != null) {
            switch (creditType) {
                case "individual":
                    return 4.0;
                case "business":
                    return 6.0;
            }
        }
        return 0.0;
    }


}
