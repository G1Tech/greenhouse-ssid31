package cc.g1cloud.greenhousessid31.repository;

import cc.g1cloud.greenhousessid31.config.DynamoDbConfiguration;
import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
@AllArgsConstructor
public class GreenhouseTelemetryRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public GreenhouseTelemetry getEmployeeById(long employeeId) {
        return dynamoDBMapper.load(GreenhouseTelemetry.class, employeeId);
    }

    public List<GreenhouseTelemetry> findAll() {
        log.info("start");

        return dynamoDBMapper.scan(GreenhouseTelemetry.class, new DynamoDBScanExpression());
    }
}





