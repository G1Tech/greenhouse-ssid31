package cc.g1cloud.greenhousessid31.controller.dto;

import cc.g1cloud.greenhousessid31.domain.DeviceData;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GreenhouseTelemetryDto {

    private String deviceId;
    private Long timestamp;
    private DeviceData deviceData;


}



