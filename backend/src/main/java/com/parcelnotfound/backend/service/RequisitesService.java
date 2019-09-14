package com.parcelnotfound.backend.service;

import com.parcelnotfound.backend.dto.CardRequisites;
import com.parcelnotfound.backend.exception.CardNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RequisitesService {

    public CardRequisites getCardRequisites(String cardId) throws CardNotFoundException {
        //TODO implement
        try {

        }
        catch (Exception e) {
            throw new CardNotFoundException("cardId must not be null", e);
        }

        return null;
    }
}
