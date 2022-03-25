package cc.g1cloud.greenhousessid31.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@DynamoDBTable(tableName = "ssid31_greenhouse")
public class GreenhouseTelemetry {

    @DynamoDBHashKey
    private Long timestamp;

    @DynamoDBAttribute
    private double temperature;

    @DynamoDBAttribute
    private double humidity;

    @DynamoDBAttribute
    private long upTime;

}



