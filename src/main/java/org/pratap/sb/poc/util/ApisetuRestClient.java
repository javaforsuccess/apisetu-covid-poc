package org.pratap.sb.poc.util;

import lombok.extern.slf4j.Slf4j;
import org.pratap.sb.poc.constants.ApisetuConstants;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
public class ApisetuRestClient {
    private static RestTemplate restTemplate = new RestTemplate();
    private static HttpHeaders headers = new HttpHeaders();
    private static ResponseEntity<String> responseAsString;
    private static HttpEntity<?> entity;
    private static UriComponentsBuilder uriComponentsBuilder;

    //GET STATES
    public String getListOfStates(String country_id){
        headers.set(ApisetuConstants.HEADER_ACCEPT_LANGUAGE,country_id);
        headers.setAccept(ApisetuConstants.HEADER_ACCEPTABLE_MEDIA_TYPES);
        headers.add(ApisetuConstants.HEADER_USER_AGENT, ApisetuConstants.HEADER_USER_AGENT_VALUE);
        uriComponentsBuilder =
                UriComponentsBuilder.fromHttpUrl(ApisetuConstants.APISETU_SERVER + ApisetuConstants.GET_STATE_URI);
        entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> response = null;
        response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
        log.info("response : {}",response);
        log.info("response Body : {}",response.getBody());
        return response.getBody();
    }

    //GET DISTRICTS
    public String getListOfDistrict(String countryId, String stateId){
        headers.set(ApisetuConstants.HEADER_ACCEPT_LANGUAGE,countryId);
        headers.setAccept(ApisetuConstants.HEADER_ACCEPTABLE_MEDIA_TYPES);
        headers.add(ApisetuConstants.HEADER_USER_AGENT, ApisetuConstants.HEADER_USER_AGENT_VALUE);
        uriComponentsBuilder =
                UriComponentsBuilder.fromHttpUrl(ApisetuConstants.APISETU_SERVER + ApisetuConstants.GET_DISTRICTS_URI+"/"+stateId);
        entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> response = null;
        response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
        log.info("response : {}",response);
        log.info("response Body : {}",response.getBody());
        return response.getBody();
    }


    //GET BY PINCODE
    public String getListByPinCode(String countryId,String pincode, String date){
        headers.set(ApisetuConstants.HEADER_ACCEPT_LANGUAGE,countryId);
        headers.setAccept(ApisetuConstants.HEADER_ACCEPTABLE_MEDIA_TYPES);
        headers.add(ApisetuConstants.HEADER_USER_AGENT, ApisetuConstants.HEADER_USER_AGENT_VALUE);
        uriComponentsBuilder =
                UriComponentsBuilder.fromHttpUrl(ApisetuConstants.APISETU_SERVER + ApisetuConstants.GET_BY_PIN_URI+"?pincode="+pincode+"&date="+date);
        entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> response = null;
        response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
        log.info("response : {}",response);
        log.info("response Body : {}",response.getBody());
        return response.getBody();
    }


}
