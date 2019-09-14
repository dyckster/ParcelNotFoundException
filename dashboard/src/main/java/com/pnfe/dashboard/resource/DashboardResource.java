package com.pnfe.dashboard.resource;

import com.pnfe.dashboard.dto.CardType;
import com.pnfe.dashboard.dto.CardView;
import com.pnfe.dashboard.dto.DashboardData;
import com.pnfe.dashboard.dto.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@Api("Данные для мобильного приложения")
public class DashboardResource {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    @ApiOperation(value = "Получение данных для главного экрана", response = DashboardData.class)
    public ResponseEntity<DashboardData> dashboardData(@ApiParam(value = "USER-ID")
                                                       @RequestHeader(value = HttpHeaders.USER_AGENT, required = false)
                                                               String userId) {
        DashboardData dashboardData = new DashboardData();

        UserInfo userInfo = new UserInfo();
        userInfo.setFullName("Иванов Иван Иванович");
        List<String> properties = new ArrayList<>();
        properties.add("SELF_EMPLOYED");

        CardView cardView = new CardView();
        cardView.setAvailableLimitAmount(10000L);
        cardView.setCardType(CardType.VIRTUAL);
        cardView.setDisplayName("Карта для бизнеса");
        cardView.setPanTail("*0173");

        List<CardView> cardViewList = new ArrayList<>();
        cardViewList.add(cardView);

        userInfo.setUserProperties(properties);
        dashboardData.setUser(userInfo);
        dashboardData.setCards(cardViewList);
        return ResponseEntity.ok(dashboardData);
    }


}
