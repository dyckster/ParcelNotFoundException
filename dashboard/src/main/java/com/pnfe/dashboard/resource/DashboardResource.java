package com.pnfe.dashboard.resource;

import com.pnfe.dashboard.dto.CardType;
import com.pnfe.dashboard.dto.CardView;
import com.pnfe.dashboard.dto.DashboardData;
import com.pnfe.dashboard.dto.UserInfo;
import com.pnfe.dashboard.service.AuthService;
import com.pnfe.dashboard.service.DashboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AuthService authService;

    @Autowired
    DashboardService dashboardService;

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


}
