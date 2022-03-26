package cc.g1cloud.greenhousessid31.repository;

import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Repository
@AllArgsConstructor
public class GreenhouseRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange(String deviceID, String from, String to) {
        Map<String, String> expressionAttributesNames = new HashMap<>();
        expressionAttributesNames.put("#device_id", "device_id");
        expressionAttributesNames.put("#timestamp","timestamp");

        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":deviceIdValue", new AttributeValue().withS(deviceID));
        expressionAttributeValues.put(":from",new AttributeValue().withN(from));
        expressionAttributeValues.put(":to", new AttributeValue().withN(to));

        DynamoDBQueryExpression<GreenhouseTelemetry> dynamoDBQueryExpression = new DynamoDBQueryExpression<GreenhouseTelemetry>()
                .withKeyConditionExpression("#device_id = :deviceIdValue and #timestamp between :from and :to")
                .withExpressionAttributeNames(expressionAttributesNames)
                .withExpressionAttributeValues(expressionAttributeValues)
                .withScanIndexForward(true);

        return dynamoDBMapper.query(GreenhouseTelemetry.class, dynamoDBQueryExpression);

    }


}





