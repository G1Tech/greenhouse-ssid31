package cc.g1cloud.greenhousessid31.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBDocument
public class DeviceData {

    @DynamoDBAttribute
    private double temperature;

    @DynamoDBAttribute
    private double humidity;

    @DynamoDBAttribute
    private long upTime;
}
