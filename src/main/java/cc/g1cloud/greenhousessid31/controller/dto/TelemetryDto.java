package cc.g1cloud.greenhousessid31.controller.dto;

import cc.g1cloud.greenhousessid31.domain.DeviceData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TelemetryDto {

    private String deviceId;
    private Long timestamp;
    private DeviceData deviceData;


}



