package org.pratap.sb.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "districts",
        "ttl"
})
public class Districts {

    @SerializedName("districts")
    @Expose
    @JsonProperty("districts")
    public List<District> districts;

    @SerializedName("ttl")
    @Expose
    @JsonProperty("ttl")
    public Integer ttl;
}
