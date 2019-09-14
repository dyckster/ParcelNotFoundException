package com.pnfe.dashboard.service;

import com.pnfe.dashboard.dto.Account;
import com.pnfe.dashboard.dto.Requisite;
import com.pnfe.dashboard.entity.AccountsEntity;
import com.pnfe.dashboard.repository.AccountsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class DashboardService {

    @Autowired
    AccountsRepository accountsRepository;

    public List<Account> getAccounts (String userId) {
        Optional<AccountsEntity> accountsEntity = accountsRepository.findById(userId);
        if (accountsEntity.isPresent()) {
            List<Account> accountList = new ArrayList<>();
            Account account = new Account();

            Requisite requisites = new Requisite();
            requisites.setAccountNumber(accountsEntity.get().getAccountNumber());
            requisites.setBik(accountsEntity.get().getBik());
            requisites.setInn(accountsEntity.get().getInn());
            requisites.setOgrnip(accountsEntity.get().getOgrnip());
            account.setRequisites(requisites);

            account.setAccountId(accountsEntity.get().getAccountId());

            accountList.add(account);
            return accountList;

        } else {
            return null;
        }
    }

}
