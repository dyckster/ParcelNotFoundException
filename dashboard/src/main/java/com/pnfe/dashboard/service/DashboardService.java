package com.pnfe.dashboard.service;

import com.pnfe.dashboard.dto.Account;
import com.pnfe.dashboard.dto.CardView;
import com.pnfe.dashboard.dto.Requisite;
import com.pnfe.dashboard.entity.AccountsEntity;
import com.pnfe.dashboard.repository.AccountsRepository;
import com.pnfe.dashboard.repository.CardsRepository;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class DashboardService {

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    CardsRepository cardsRepository;

    public List<Account> getAccounts(String userId) {
        List<AccountsEntity> accountsEntities = accountsRepository.findByUserId(userId);
        List<Account> accounts = new ArrayList<>();

        if (!CollectionUtils.isEmpty(accountsEntities)) {
            accounts = accountsEntities.stream().map(accountsEntity -> {
                Account account = new Account();
                Requisite requisites = new Requisite(
                        accountsEntity.getInn(),
                        accountsEntity.getOgrnip(),
                        accountsEntity.getAccountNumber(),
                        accountsEntity.getBankBik(),
                        accountsEntity.getClientBik()
                );
                account.setRequisites(requisites);
                account.setAccountId(accountsEntity.getAccountId());
                account.setCards(getCards(accountsEntity.getAccountId()));
                return account;
            }).collect(Collectors.toList());

        }
        return accounts;
    }

    private List<CardView> getCards(String accountId) {
        List<CardView> cards;
        cards = cardsRepository.findByAccountId(accountId).stream().map(card -> {
            CardView cardView = new CardView();
            try {
                BeanUtils.copyProperties(card, cardView);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String panTail = card.getPan().substring(card.getPan().length() - 4);
            cardView.setPanTail("*" + panTail);
            return cardView;
        }).collect(Collectors.toList());
        return cards;
    }

}
