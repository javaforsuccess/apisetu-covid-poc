package org.pratap.sb.poc.constants;

import org.springframework.http.MediaType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public interface ApisetuConstants {
    String COUNTRY_CODE = "IN";
    String APISETU_SERVER = "https://cdn-api.co-vin.in";
    String GET_STATE_URI = "/api/v2/admin/location/states";
    String GET_DISTRICTS_URI = "/api/v2/admin/location/districts/";
    String GET_BY_PIN_URI = "/api/v2/appointment/sessions/public/findByPin";
    String GET_BY_DISTRICTS_URI = "/api/v2/appointment/sessions/public/findByDistrict";

    String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    List<MediaType> HEADER_ACCEPTABLE_MEDIA_TYPES = Arrays.asList(MediaType.APPLICATION_JSON);
    String HEADER_USER_AGENT = "user-agent";
    String HEADER_USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";

    DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
}
