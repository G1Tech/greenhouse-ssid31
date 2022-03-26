package cc.g1cloud.greenhousessid31.service;

import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;

public interface GreenhouseService {

    PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange(String deviceID, String from, String to);

}
