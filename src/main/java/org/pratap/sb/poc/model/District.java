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
        "district_id",
        "district_name"
})
public class District {

    @SerializedName("district_id")
    @Expose
    @JsonProperty("district_id")
    public Integer district_id;

    @SerializedName("district_name")
    @Expose
    @JsonProperty("district_name")
    public String district_name;

}
