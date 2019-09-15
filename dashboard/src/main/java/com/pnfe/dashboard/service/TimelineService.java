package com.pnfe.dashboard.service;

import com.pnfe.dashboard.dto.*;
import com.pnfe.dashboard.entity.OperationEntity;
import com.pnfe.dashboard.repository.OperationsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TimelineService {

    public static final long ZERO_RUB = 0L;
    public static final double INDIVIDUAL_TAX_PERCENT = 4.0;
    public static final double BUSINESS_TAX_AMOUNT = 6.0;
    @Autowired
    OperationsRepository operationsRepository;


    public OperationsView getTimeline(String cardId) {
        OperationsView operationsView = new OperationsView();
        List<OperationView> operations = getOperations(cardId);
        operationsView.setOperations(operations);
        operationsView.setTotalAmounts(getTotalAmount(operations));
        return operationsView;
    }

    private List<OperationView> getOperations(String cardId) {
        List<OperationEntity> operationEntities = operationsRepository.findByCardId(cardId);
        return convertOperations(operationEntities);
    }

    private List<OperationView> convertOperations(List<OperationEntity> operationEntities) {
        return operationEntities.stream().map(operationEntity -> {
            OperationView operationView = new OperationView();
            operationView.setTaxPercent(getTaxPercentage(operationEntity.getCreditType()));

            if (operationView.getTaxPercent() != 0.0) {
                Long taxPercent = new Double(operationView.getTaxPercent()).longValue();
                Long taxAmount = ((operationEntity.getAmount()) / 100 * taxPercent);
                operationView.setTaxAmount(taxAmount);
            }
            try {
                BeanUtils.copyProperties(operationEntity, operationView);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return operationView;
        }).collect(Collectors.toList());
    }

    private TotalAmount getTotalAmount(List<OperationView> operations) {
        TotalAmount totalAmount = new TotalAmount();
        Long amountCredit = operations
                .stream()
                .filter(op -> op.getAmount() > ZERO_RUB)
                .map(OperationView::getAmount)
                .reduce(ZERO_RUB, Long::sum);
        totalAmount.setTotalCredit(amountCredit);

        Long amountDebit = operations
                .stream()
                .filter(op -> op.getAmount() < ZERO_RUB)
                .map(OperationView::getAmount)
                .reduce(ZERO_RUB, Long::sum);

        totalAmount.setTotalDebit(amountDebit);

        Long amountTax = operations
                .stream()
                .map(OperationView::getTaxAmount)
                .reduce(ZERO_RUB, Long::sum);
        totalAmount.setTotalTax(amountTax);

        Map<Month, Long> creditByMonth = operations
                .stream()
                .filter(op -> op.getAmount() > ZERO_RUB)
                .collect(Collectors.groupingBy(p -> p.getOperDate().getMonth(), Collectors.summingLong(OperationView::getAmount)));

        List<Map<Month, Long>> monthlyCredit = new ArrayList<>();
        monthlyCredit.add(creditByMonth);

        Map<Month, Long> debitByMonth = operations
                .stream()
                .filter(op -> op.getAmount() < ZERO_RUB)
                .collect(Collectors.groupingBy(p -> p.getOperDate().getMonth(), Collectors.summingLong(OperationView::getAmount)));

        List<Map<Month, Long>> monthlyDebit = new ArrayList<>();
        monthlyDebit.add(debitByMonth);


        Map<Month, Long> taxByMonth = operations
                .stream()
                .filter(op -> op.getTaxAmount() != ZERO_RUB)
                .collect(Collectors.groupingBy(p -> p.getOperDate().getMonth(), Collectors.summingLong(OperationView::getTaxAmount)));

        List<Map<Month, Long>> monthlyTax = new ArrayList<>();
        monthlyTax.add(taxByMonth);


        totalAmount.setMonthlyDebit(monthlyDebit);
        totalAmount.setMonthlyCredit(monthlyCredit);
        totalAmount.setMonthlyTax(monthlyTax);

        return totalAmount;
    }

    public TimelineSummary getTimelineSummary(String cardId) {
        List<OperationView> operations = getOperations(cardId);
        Long creditByCurrentMonth = operations
                .stream()
                .filter(op -> op.getAmount() > ZERO_RUB
                        && LocalDate.now().getMonth().equals(op.getOperDate().getMonth()))
                .mapToLong(OperationView::getAmount)
                .sum();

        Long taxByCurrentMonth = operations
                .stream()
                .filter(op -> LocalDate.now().getMonth().equals(op.getOperDate().getMonth()))
                .mapToLong(OperationView::getTaxAmount)
                .sum();

        return new TimelineSummary(creditByCurrentMonth, taxByCurrentMonth);

    }

    private double getTaxPercentage(String creditType) {
        if (creditType != null) {
            switch (creditType) {
                case "individual":
                    return INDIVIDUAL_TAX_PERCENT;
                case "business":
                    return BUSINESS_TAX_AMOUNT;
            }
        }
        return 0.0;
    }


}
