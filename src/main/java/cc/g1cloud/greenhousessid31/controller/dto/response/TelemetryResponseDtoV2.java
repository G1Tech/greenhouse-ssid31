package cc.g1cloud.greenhousessid31.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TelemetryResponseDtoV2 {

    private String deviceId;
    private Long timestamp;
    private double temperature;
    private double humidity;
    private long upTime;

}



