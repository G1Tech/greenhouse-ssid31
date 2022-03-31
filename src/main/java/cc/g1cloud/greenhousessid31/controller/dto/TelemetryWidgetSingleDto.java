package cc.g1cloud.greenhousessid31.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.DoubleSummaryStatistics;

@Getter
@Setter
@Builder
public class TelemetryWidgetSingleDto {

    private String deviceId;
    private Long timestamp;
    private double temperature;
    private DoubleSummaryStatistics temperatureStatistics;
    private double humidity;
    private DoubleSummaryStatistics humidityStatistics;
    private long upTime;

}



