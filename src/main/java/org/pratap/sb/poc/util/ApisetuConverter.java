package org.pratap.sb.poc.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.pratap.sb.poc.model.*;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;

public class ApisetuConverter {
    private Gson gson = new Gson();

    public States getStatesNodeFrom(@NotNull String responseBody) {
        Type type = new TypeToken<States>() {
        }.getType();
        States states = gson.fromJson(responseBody, type);
        return states;
    }

    public String getStatesForDisplay(@NotNull States states) {
        int i = 3;
        String s = new String("");
        if (null != states.getStates() && !states.getStates().isEmpty()) {
            s = s + "TOTAL STATES : " + states.getTtl() + "\n";
            s = s + "[ STATE CODE ] : [STATE NAME]\n";
            for (State eachState : states.getStates()) {
                i++;
                if (null != eachState.getStateId() && null != eachState.getStateName())
                    if (i % 3 == 0)
                        s = s + "\n";
                s = s + "[" + eachState.getStateId() + "] : " + eachState.getStateName() + "  ";
            }
        }
        return s;
    }

    public Districts getDistrictsNodeFrom(@NotNull String responseBody) {
        Type type = new TypeToken<Districts>() {
        }.getType();
        Districts districts = gson.fromJson(responseBody, type);
        return districts;
    }

    public String getDistrictsForDisplay(@NotNull Districts districts) {
        int i = 3;
        String s = new String("");
        if (null != districts.getDistricts() && !districts.getDistricts().isEmpty()) {
            s = s + "TOTAL DISTRICTS : " + districts.getTtl() + "\n";
            s = s + "[ DISTT CODE ] : [DISTT NAME]\n";
            for (District eachDistrict : districts.getDistricts()) {
                i++;
                if (null != eachDistrict.getDistrict_id() && null != eachDistrict.getDistrict_name())
                    if (i % 6 == 0)
                        s = s + "\n";
                s = s + "[" + eachDistrict.getDistrict_id() + "] : " + eachDistrict.getDistrict_name() + "  ";
            }
        }
        return s;
    }

    public Sessions getSessionsByPincodeNodeFrom(@NotNull String responseBody) {
        Type type = new TypeToken<Sessions>() {
        }.getType();
        Sessions sessions = gson.fromJson(responseBody, type);
        return sessions;
    }

    public String getSessionsByPincodeDoseAndAgeLimitForDisplay(@NotNull Sessions sessions, @NotNull String dose, @NotNull int minimumAgeLimit) {
        int i = 3;
        String s = new String("");
        if (null != sessions.getSessions() && !sessions.getSessions().isEmpty()) {
            s = s + "TOTAL SESSIONS : " + sessions.getSessions().size() + "\n";
            for (Session eachSession : sessions.getSessions()) {
                if (dose.equalsIgnoreCase("1") && eachSession.getMinAgeLimit() <= minimumAgeLimit) {
                    if (eachSession.getAvailableCapacityDose1() > 0) {
                        s = s + "NAME.....: " + eachSession.getName() + "\n";
                        s = s + "BLOCK....: " + eachSession.getBlockName() + "\n";
                        s = s + "TIME.....: " + eachSession.getFrom() + " - " + eachSession.getTo() + "\n";
                        s = s + "FEE TYPE.: " + eachSession.feeType + "\n";
                        s = s + "FEE......: " + eachSession.getFee() + "\n";
                        s = s + "MIN AGE..: " + eachSession.getMinAgeLimit() + "\n";
                        s = s + "VACCINE..: " + eachSession.getVaccine();
                        if (null != eachSession.getSlots() && !eachSession.getSlots().isEmpty()) {
                            s = s + "SLOTS....: " + "\n";
                            for (String eachSlot : eachSession.getSlots()) {
                                s = s + "---- " + eachSlot;
                            }
                        }
                        s = s + "__________________________________________________\n";
                    }
                } else {
                    if (eachSession.getAvailableCapacityDose2() > 0 && eachSession.getMinAgeLimit() <= minimumAgeLimit) {
                        s = s + "NAME.....: " + eachSession.getName() + "\n";
                        s = s + "BLOCK....: " + eachSession.getBlockName() + "\n";
                        s = s + "TIME.....: " + eachSession.getFrom() + " - " + eachSession.getTo() + "\n";
                        s = s + "FEE TYPE.: " + eachSession.feeType + "\n";
                        s = s + "FEE......: " + eachSession.getFee() + "\n";
                        s = s + "MIN AGE..: " + eachSession.getMinAgeLimit() + "\n";
                        s = s + "VACCINE..: " + eachSession.getVaccine();
                        if (null != eachSession.getSlots() && !eachSession.getSlots().isEmpty()) {
                            s = s + "SLOTS....: " + "\n";
                            for (String eachSlot : eachSession.getSlots()) {
                                s = s + "---- " + eachSlot + "\n";
                            }
                        }
                        s = s + "__________________________________________________\n";
                    }
                }
            }
        }
        return s;
    }
}
