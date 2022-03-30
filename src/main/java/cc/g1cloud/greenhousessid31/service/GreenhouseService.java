package cc.g1cloud.greenhousessid31.service;

import cc.g1cloud.greenhousessid31.controller.dto.GreenhouseTelemetryDtoV2;
import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;

import java.util.List;

public interface GreenhouseService {

    PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange(String deviceID, String from, String to);
    List<GreenhouseTelemetryDtoV2> findTelemetryRangeV2(String deviceID, String from, String to);

}
