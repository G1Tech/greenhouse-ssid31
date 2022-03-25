package cc.g1cloud.greenhousessid31.repository;

import cc.g1cloud.greenhousessid31.config.DynamoDbConfiguration;
import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class GreenhouseTelemetryRepository {

    private final DynamoDbConfiguration dynamoDbConfiguration;

    public GreenhouseTelemetry getEmployeeById(long employeeId) {
        return dynamoDbConfiguration.dynamoDBMapper().load(GreenhouseTelemetry.class, employeeId);
    }

}



