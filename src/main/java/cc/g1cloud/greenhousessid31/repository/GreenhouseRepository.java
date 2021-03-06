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
        DynamoDBQueryExpression<GreenhouseTelemetry> dynamoDBQueryExpression = new DynamoDBQueryExpression<GreenhouseTelemetry>()
                .withKeyConditionExpression(getKeyCondition(from, to))
                .withExpressionAttributeNames(getExpressionAttributesNames(from, to))
                .withExpressionAttributeValues(getExpressionAttributeValues(deviceID, from, to))
                .withScanIndexForward(true);
        return dynamoDBMapper.query(GreenhouseTelemetry.class, dynamoDBQueryExpression);
    }

    private String getKeyCondition(String from, String to) {
        if (from != null && to != null) return "#device_id = :deviceIdValue and #timestamp between :from and :to";
        if (from != null) return "#device_id = :deviceIdValue and #timestamp > :from";
        if (to != null) return "#device_id = :deviceIdValue and #timestamp < :to";
        return "#device_id = :deviceIdValue";
    }

    private Map<String, String> getExpressionAttributesNames(String from, String to) {
        Map<String, String> expressionAttributesNames = new HashMap<>();
        expressionAttributesNames.put("#device_id", "device_id");
        if (from != null || to != null) expressionAttributesNames.put("#timestamp", "timestamp");
        return expressionAttributesNames;
    }

    private Map<String, AttributeValue> getExpressionAttributeValues(String deviceID, String from, String to) {
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":deviceIdValue", new AttributeValue().withS(deviceID));
        if (from != null) expressionAttributeValues.put(":from", new AttributeValue().withN(from));
        if (to != null) expressionAttributeValues.put(":to", new AttributeValue().withN(to));
        return expressionAttributeValues;
    }

}





