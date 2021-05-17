package org.pratap.sb.poc;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.pratap.sb.poc.constants.ApisetuConstants;
import org.pratap.sb.poc.model.Districts;
import org.pratap.sb.poc.model.Sessions;
import org.pratap.sb.poc.model.States;
import org.pratap.sb.poc.util.ApisetuConverter;
import org.pratap.sb.poc.util.ApisetuRestClient;

import javax.swing.*;
import java.util.Date;

@Slf4j
public class ApisetuNotifierApplication {

    private static ApisetuConverter apisetuConverter = new ApisetuConverter();
    private static ApisetuRestClient apisetuRestClient = new ApisetuRestClient();

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        log.info("get country code");
        //GET COUNTRY
        String countryId = null;
        //String countryId = JOptionPane.showInputDialog("Enter Country ID (default : IN) :");
        if (!(null != countryId && !countryId.trim().isEmpty())) {
            countryId = ApisetuConstants.COUNTRY_CODE;
        }

        //log.info("get state code");
        //GET STATES CODE
        //String stateId = getStateCode(countryId);


        //log.info("get district code");
        //GET DISTRICT CODE
        //String districtId = getDistrictCode(countryId,stateId);

        log.info("get by pin number");
        // GET BY PIN NUMBER
        getByPincodeDoseAndAgeLimit(countryId);

        System.out.println("+++++++END++++++");
    }


    //GET BY PIN NUMBER
    private static void getByPincodeDoseAndAgeLimit(String countryId) {
        boolean isContinueSelected = true;
        Date today = null;
        while(isContinueSelected) {
            today = new Date();
            String pincode = JOptionPane.showInputDialog("Enter State ID (default : 560066) :");
            if (!(null != pincode && !pincode.trim().isEmpty())) {
                pincode = "560066";
            }
            String date = JOptionPane.showInputDialog("Enter DATE \n(default : "+ApisetuConstants.dateFormatter.format(today)+") \n (MM-DD-YYYY) :");
            if(!(null!=date && !date.isEmpty())){
                date = ApisetuConstants.dateFormatter.format(today);
            }
            String ageLimit = JOptionPane.showInputDialog("Enter AGE (default : 45) :");
            int age = 45;
            if (null != ageLimit && !ageLimit.isEmpty())
                age = Integer.parseInt(ageLimit.trim());
            String dose = JOptionPane.showInputDialog("1 : for 1st Dose \n 2 : for 2nd Dose \n default is 1 \n Enter DOSE :");
            if (!(null != dose && !dose.isEmpty()))
                dose = "1";
            Sessions sessions = apisetuConverter.getSessionsByPincodeNodeFrom(apisetuRestClient.getListByPinCode(countryId, pincode, date));
            String sessionsByPincodeDoseAndAgeLimit = apisetuConverter.getSessionsByPincodeDoseAndAgeLimitForDisplay(sessions, dose, age);
            JOptionPane.showMessageDialog(null, sessionsByPincodeDoseAndAgeLimit, "SESSIONS", JOptionPane.PLAIN_MESSAGE);
            String wantToContinue = JOptionPane.showInputDialog("Do you want to Continue (Y/N) :");
            if (null != wantToContinue && !wantToContinue.isEmpty() && ("Y".equalsIgnoreCase(wantToContinue) || "Yes".equalsIgnoreCase(wantToContinue)))
                isContinueSelected = true;
            else
                isContinueSelected = false;
        }
    }

    //GET LIST OF DISTRICT
    private static String getDistrictCode(String countryId, String stateId) {
        Districts districts = apisetuConverter.getDistrictsNodeFrom(apisetuRestClient.getListOfDistrict(countryId,stateId));
        String districtListWithCode = apisetuConverter.getDistrictsForDisplay(districts);
        JOptionPane.showMessageDialog(null, districtListWithCode, "RESULT", JOptionPane.PLAIN_MESSAGE);
        String districtId = JOptionPane.showInputDialog("Enter District ID (default : 667) :");
        if (null != districtId && !districtId.trim().isEmpty())
            return districtId.trim();
        else
            return "667";
    }

    //GET LIST OF STATES
    public static String getStateCode(String country_id) throws JsonProcessingException, ParseException {
        States states = apisetuConverter.getStatesNodeFrom(apisetuRestClient.getListOfStates(country_id));
        String stateListWithCode = apisetuConverter.getStatesForDisplay(states);
        JOptionPane.showMessageDialog(null, stateListWithCode, "RESULT", JOptionPane.PLAIN_MESSAGE);
        String stateId = JOptionPane.showInputDialog("Enter State ID (default : 34) :");
        if (null != stateId && !stateId.trim().isEmpty())
            return stateId.trim();
        else
            return "34";
    }
}
