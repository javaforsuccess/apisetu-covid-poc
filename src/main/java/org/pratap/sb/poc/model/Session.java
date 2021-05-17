package org.pratap.sb.poc.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "center_id",
        "name",
        "address",
        "state_name",
        "district_name",
        "block_name",
        "pincode",
        "from",
        "to",
        "lat",
        "long",
        "fee_type",
        "session_id",
        "date",
        "available_capacity_dose1",
        "available_capacity_dose2",
        "available_capacity",
        "fee",
        "min_age_limit",
        "vaccine",
        "slots"
})
public class Session {

    @JsonProperty("center_id")
    @SerializedName("center_id")
    @Expose
    public Integer centerId;

    @SerializedName("name")
    @Expose
    @JsonProperty("name")
    public String name;

    @SerializedName("address")
    @Expose
    @JsonProperty("address")
    public String address;

    @SerializedName("state_name")
    @Expose
    @JsonProperty("state_name")
    public String stateName;

    @SerializedName("district_name")
    @Expose
    @JsonProperty("district_name")
    public String districtName;

    @SerializedName("block_name")
    @Expose
    @JsonProperty("block_name")
    public String blockName;

    @SerializedName("pincode")
    @Expose
    @JsonProperty("pincode")
    public Integer pincode;

    @SerializedName("from")
    @Expose
    @JsonProperty("from")
    public String from;

    @SerializedName("to")
    @Expose
    @JsonProperty("to")
    public String to;

    @SerializedName("lat")
    @Expose
    @JsonProperty("lat")
    public Integer lat;

    @SerializedName("long")
    @Expose
    @JsonProperty("long")
    public Integer _long;

    @SerializedName("fee_type")
    @Expose
    @JsonProperty("fee_type")
    public String feeType;

    @SerializedName("session_id")
    @Expose
    @JsonProperty("session_id")
    public String sessionId;

    @SerializedName("date")
    @Expose
    @JsonProperty("date")
    public String date;

    @SerializedName("available_capacity_dose1")
    @Expose
    @JsonProperty("available_capacity_dose1")
    public Integer availableCapacityDose1;

    @SerializedName("available_capacity_dose2")
    @Expose
    @JsonProperty("available_capacity_dose2")
    public Integer availableCapacityDose2;

    @SerializedName("available_capacity")
    @Expose
    @JsonProperty("available_capacity")
    public Integer availableCapacity;

    @SerializedName("fee")
    @Expose
    @JsonProperty("fee")
    public String fee;

    @SerializedName("min_age_limit")
    @Expose
    @JsonProperty("min_age_limit")
    public Integer minAgeLimit;

    @SerializedName("vaccine")
    @Expose
    @JsonProperty("vaccine")
    public String vaccine;

    @SerializedName("slots")
    @Expose
    @JsonProperty("slots")
    public List<String> slots = null;
}