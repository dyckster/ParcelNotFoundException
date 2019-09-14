package com.parcelnotfound.backend.rs;


import com.parcelnotfound.backend.dto.CardRequisites;
import com.parcelnotfound.backend.exception.CardNotFoundException;
import com.parcelnotfound.backend.service.RequisitesService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/parcelnotfoundexception/api")
@Api(value = "API для мобильного приложения")
public class DashboardResource {

    @Autowired
    RequisitesService requisitesService;

    @RequestMapping(value = "/cards/{cardId}/requisites/", method = RequestMethod.GET)
    @ApiOperation(value = "Метод для получения реквизитов виртуальной карты", response = CardRequisites.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 404, message = "Карта с переданным ID не найдена"),
                    @ApiResponse(code = 500, message = "Ошибка обработки запроса")
            }
    )
    public ResponseEntity cardRequisites(@ApiParam(value = "Канал запроса", required = true)
                                            @PathVariable("cardId") @NotNull
                                                    String cardId) {
        try {
            CardRequisites cardRequisites = requisitesService.getCardRequisites(cardId);
            return ResponseEntity.ok(cardRequisites);
        } catch (CardNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
