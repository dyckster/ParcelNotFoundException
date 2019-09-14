package com.parcelnotfound.backend.service;

import com.parcelnotfound.backend.dto.CardRequisites;
import com.parcelnotfound.backend.entity.Test;
import com.parcelnotfound.backend.exception.CardNotFoundException;
import com.parcelnotfound.backend.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequisitesService {

    @Autowired
    TestRepository testRepository;

    public CardRequisites getCardRequisites(String cardId) throws CardNotFoundException {
        //TODO implement
        try {

        } catch (Exception e) {
            throw new CardNotFoundException("cardId must not be null", e);
        }

        return null;
    }

    public Test testJpa() {
        return testRepository.findById(1);
    }
}
