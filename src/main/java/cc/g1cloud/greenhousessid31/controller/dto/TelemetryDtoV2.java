package cc.g1cloud.greenhousessid31.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TelemetryDtoV2 {

    private String deviceId;
    private Long timestamp;
    private double temperature;
    private double humidity;
    private long upTime;

}



