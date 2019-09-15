package com.pnfe.dashboard.resource;

import com.pnfe.dashboard.dao.FnsDao;
import com.pnfe.dashboard.dto.*;
import com.pnfe.dashboard.dto.fns.FnsSearchResponse;
import com.pnfe.dashboard.dto.fns.FnsSearchResult;
import com.pnfe.dashboard.entity.OperationEntity;
import com.pnfe.dashboard.service.AuthService;
import com.pnfe.dashboard.service.DashboardService;
import com.pnfe.dashboard.service.TimelineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@Api("Данные для мобильного приложения")
public class DashboardResource {

    @Autowired
    AuthService authService;

    @Autowired
    DashboardService dashboardService;

    @Autowired
    TimelineService timelineService;

    @Autowired
    FnsDao fnsDao;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    @ApiOperation(value = "Получение данных для главного экрана", response = DashboardData.class)
    public ResponseEntity<DashboardData> dashboardData(@ApiParam(value = "USER-ID")
                                                       @RequestHeader(value = "USER-ID", required = true)
                                                               String userId) {

        UserInfo userInfo = authService.retrieveUserInfo(userId);
        if (userInfo != null) {
            DashboardData dashboardData = new DashboardData();
            dashboardData.setUser(userInfo);
            dashboardData.setAccounts(dashboardService.getAccounts(userId));
            return ResponseEntity.ok(dashboardData);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/partners/{inn}", method = RequestMethod.GET)
    @ApiOperation(value = "Получение данных по контрагенту", response = FnsSearchResponse.class)
    public ResponseEntity<FnsSearchResponse> fnsSearchResponse(@PathVariable("inn") @NotNull
                                                                       String inn) {
        FnsSearchResponse fnsSearchResponse = fnsDao.searchByInn(inn);
        return ResponseEntity.ok(fnsSearchResponse);
    }

    @RequestMapping(value = "/operations/{cardId}", method = RequestMethod.GET)
    @ApiOperation(value = "Получение ленты операций", response = OperationsView.class)
    public ResponseEntity<OperationsView> operations(@ApiParam(value = "USER-ID")
                                                            @RequestHeader(value = "USER-ID", required = true)
                                                                    String userId, @PathVariable("cardId") @NotNull
                                                                    String cardId) {

        UserInfo userInfo = authService.retrieveUserInfo(userId);
        if (userInfo != null) {
            return ResponseEntity.ok(timelineService.getTimeline(cardId));
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/requisites/{cardId}", method = RequestMethod.GET)
    @ApiOperation(value = "Получение реквизитов виртуальной карты", response = CardRequisites.class)
    public ResponseEntity<CardRequisites> cardRequisites(@ApiParam(value = "USER-ID")
                                                            @RequestHeader(value = "USER-ID", required = true)
                                                                    String userId, @PathVariable("cardId") @NotNull
                                                                    String cardId) {

        UserInfo userInfo = authService.retrieveUserInfo(userId);
        if (userInfo != null) {
            return ResponseEntity.ok(dashboardService.getCardRequisites(cardId));
        }
        return ResponseEntity.badRequest().build();
    }


}
