package com.example.open_meteo_download.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "latitude",
        "longitude",
        "generationtime_ms",
        "utc_offset_seconds",
        "timezone",
        "timezone_abbreviation",
        "elevation",
        "hourly_units",
        "hourly"
})
@Generated("jsonschema2pojo")
@Data
public class OpenMeteoResponse {

    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("generationtime_ms")
    private Double generationtimeMs;
    @JsonProperty("utc_offset_seconds")
    private Integer utcOffsetSeconds;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;
    @JsonProperty("elevation")
    private Double elevation;
    @JsonProperty("hourly_units")
    private HourlyUnits hourlyUnits;
    @JsonProperty("hourly")
    private Hourly hourly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "time",
            "temperature_2m",
            "shortwave_radiation"
    })
    @Generated("jsonschema2pojo")
    @Data
    public class Hourly {

        @JsonProperty("time")
        private List<String> time = null;
        @JsonProperty("temperature_2m")
        private List<Double> temperature2m = null;
        @JsonProperty("shortwave_radiation")
        private List<Double> shortwaveRadiation = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "time",
            "temperature_2m",
            "shortwave_radiation"
    })
    @Generated("jsonschema2pojo")
    @Data
    public class HourlyUnits {

        @JsonProperty("time")
        private String time;
        @JsonProperty("temperature_2m")
        private String temperature2m;
        @JsonProperty("shortwave_radiation")
        private String shortwaveRadiation;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    }
}
