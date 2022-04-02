package cc.g1cloud.greenhousessid31.controller.dto.response;

import cc.g1cloud.greenhousessid31.domain.DeviceData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TelemetryResponseDto {

    private String deviceId;
    private Long timestamp;
    private DeviceData deviceData;


}



