package cc.g1cloud.greenhousessid31.mapper;

import cc.g1cloud.greenhousessid31.controller.dto.GreenhouseTelemetryDtoV2;
import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GreenhouseTelemetryMapper {

    public GreenhouseTelemetryDtoV2 toDtoV2(final GreenhouseTelemetry greenhouseTelemetry) {
        return GreenhouseTelemetryDtoV2.builder()
                .deviceId(greenhouseTelemetry.getDeviceId())
                .timestamp(greenhouseTelemetry.getTimestamp())
                .temperature(greenhouseTelemetry.getDeviceData().getTemperature())
                .humidity(greenhouseTelemetry.getDeviceData().getHumidity())
                .build();
    }

}
