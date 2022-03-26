package cc.g1cloud.greenhousessid31.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBTable(tableName = "greenhouse_ssid31_esp")
public class GreenhouseTelemetry {

    @DynamoDBHashKey(attributeName = "device_id")
    private String deviceId;

    @DynamoDBAttribute
    private Long timestamp;

    @DynamoDBAttribute(attributeName = "device_data")
    private DeviceData deviceData;


}



