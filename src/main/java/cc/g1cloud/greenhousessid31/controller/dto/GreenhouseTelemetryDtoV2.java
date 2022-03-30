package cc.g1cloud.greenhousessid31.controller.dto;

import cc.g1cloud.greenhousessid31.domain.DeviceData;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Builder
public class GreenhouseTelemetryDtoV2 {

    private String deviceId;
    private Long timestamp;
    private double temperature;
    private double humidity;
    private long upTime;

}



