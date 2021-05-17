package org.pratap.sb.poc.model;

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
        "state_id",
        "state_name"
})
public class State {
    @SerializedName("state_id")
    @Expose
    @JsonProperty("state_id")
    public Integer stateId;
    @SerializedName("state_name")
    @Expose
    @JsonProperty("state_name")
    public String stateName;
}
