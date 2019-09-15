package com.pnfe.dashboard.dao;

import com.pnfe.dashboard.dto.fns.FnsSearchResponse;
import org.apache.http.entity.ContentType;
import org.slf4j.MDC;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FnsDao {


    //TODO вынести в конфиг
    public static final String requestUrl= "https://api-fns.ru/api/check?req={}&key=c3e90ec7c07c3aa1a95cc9d82ac40b794ffa7656";

    public FnsSearchResponse searchByInn (String inn) {
        RestTemplate fnsClient = new RestTemplate();
        String url = requestUrl.replace("{}",inn);
        ResponseEntity<FnsSearchResponse> entity = fnsClient.exchange(url, HttpMethod.GET, createBaseEntity(null), FnsSearchResponse.class);
        return entity.getBody();
    }

    public static HttpEntity createBaseEntity(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-uuid", MDC.get("uuid"));
        headers.set("Content-Type", ContentType.APPLICATION_JSON.toString());
        headers.set("Accept", ContentType.APPLICATION_JSON.toString());
        HttpEntity request = null;
        if (body == null) {
            request = new HttpEntity(headers);
        } else {
            request = new HttpEntity(body, headers);
        }

        return request;
    }

}
