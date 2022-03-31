package cc.g1cloud.greenhousessid31.mapper;

import cc.g1cloud.greenhousessid31.controller.dto.TelemetryDtoV2;
import cc.g1cloud.greenhousessid31.controller.dto.TelemetryWidgetSingleDto;
import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GreenhouseTelemetryMapper {

    public TelemetryDtoV2 toDtoV2(final GreenhouseTelemetry greenhouseTelemetry) {
        return TelemetryDtoV2.builder()
                .deviceId(greenhouseTelemetry.getDeviceId())
                .timestamp(greenhouseTelemetry.getTimestamp())
                .temperature(greenhouseTelemetry.getDeviceData().getTemperature())
                .humidity(greenhouseTelemetry.getDeviceData().getHumidity())
                .build();
    }

    public TelemetryWidgetSingleDto toWidgetSingleDto(List<GreenhouseTelemetry> telemetryDtoList) {
        int index = telemetryDtoList.size() - 1;
        DoubleSummaryStatistics temperatureStats = new DoubleSummaryStatistics();
        DoubleSummaryStatistics humidityStats = new DoubleSummaryStatistics();

        telemetryDtoList = telemetryDtoList.stream()
                .sorted(Comparator.comparing(GreenhouseTelemetry::getTimestamp))
                .collect(Collectors.toList());

        telemetryDtoList.forEach(d -> {
                    temperatureStats.accept(d.getDeviceData().getTemperature());
                    humidityStats.accept(d.getDeviceData().getHumidity());
                }
        );

        return TelemetryWidgetSingleDto.builder()
                .deviceId(telemetryDtoList.get(index).getDeviceId())
                .timestamp(telemetryDtoList.get(index).getTimestamp())
                .temperature(telemetryDtoList.get(index).getDeviceData().getTemperature())
                .humidity(telemetryDtoList.get(index).getDeviceData().getHumidity())
                .temperatureStatistics(temperatureStats)
                .humidityStatistics(humidityStats)
                .upTime(telemetryDtoList.get(index).getDeviceData().getUpTime())
                .build();
    }


}
