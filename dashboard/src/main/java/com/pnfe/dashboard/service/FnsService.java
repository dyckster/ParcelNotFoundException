package com.pnfe.dashboard.service;

import com.pnfe.dashboard.dao.FnsDao;
import com.pnfe.dashboard.dto.fns.CompanyDescription;
import com.pnfe.dashboard.dto.fns.FnsSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FnsService {
    @Autowired
    FnsDao fnsDao;

    public List<CompanyDescription> mapCompanyDescriptions(String inn) {
        List<CompanyDescription> companyDescriptions = new ArrayList<>();
        FnsSearchResponse response = fnsDao.searchByInn(inn);
        companyDescriptions = response.getItems().stream().map(r -> {
            CompanyDescription companyDescription = new CompanyDescription();
            if (r.getCompany() != null) {
                companyDescription.setCloseDate(r.getCompany().getCloseDate());
                companyDescription.setFullAddress(r.getCompany().getFullAddress());
            }
            return companyDescription;
        }).collect(Collectors.toList());
        return companyDescriptions;
    }


}
