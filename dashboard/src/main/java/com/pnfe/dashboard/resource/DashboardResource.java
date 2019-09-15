package com.pnfe.dashboard.resource;

import com.pnfe.dashboard.dto.*;
import com.pnfe.dashboard.dto.fns.CompanyDescription;
import com.pnfe.dashboard.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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
    FnsService fnsService;

    @Autowired
    StoriesService storiesService;

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
            // Меня очень попросила наша дизайнер
            String cardId = dashboardData.getAccounts().get(0).getCards().get(0).getId();

            dashboardData.setTimelineSummary(timelineService.getTimelineSummary(cardId));
            return ResponseEntity.ok(dashboardData);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/partners/{inn}", method = RequestMethod.GET)
    @ApiOperation(value = "Получение данных по контрагенту", response = CompanyDescription.class)
    public ResponseEntity<List<CompanyDescription>> fnsSearchResponse(@PathVariable("inn") @NotNull
                                                                       String inn) {
        List<CompanyDescription> companyDescriptions = fnsService.mapCompanyDescriptions(inn);
        return ResponseEntity.ok(companyDescriptions);
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

    @RequestMapping(value = "/stories", method = RequestMethod.GET)
    @ApiOperation(value = "Получение контента для историй", response = Story.class)
    public ResponseEntity<List<Story>> stories(@ApiParam(value = "USER-ID")
                                                         @RequestHeader(value = "USER-ID", required = true)
                                                                 String userId) {

        UserInfo userInfo = authService.retrieveUserInfo(userId);
        if (userInfo != null) {
            return ResponseEntity.ok(storiesService.getStories(userId));
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/stories/view/{storyId}", method = RequestMethod.PUT)
    @ApiOperation(value = "Пометить историю как прочитанную")
    public ResponseEntity<List<Story>> stories(@ApiParam(value = "USER-ID")
                                               @RequestHeader(value = "USER-ID", required = true)
                                                       String userId, @PathVariable("storyId") @NotNull
            String storyId) {

        UserInfo userInfo = authService.retrieveUserInfo(userId);
        if (userInfo != null) {
            try {
                storiesService.setStoryRead(storyId);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }



}
