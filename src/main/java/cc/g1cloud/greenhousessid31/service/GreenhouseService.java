package cc.g1cloud.greenhousessid31.service;

import cc.g1cloud.greenhousessid31.controller.dto.TelemetryDtoV2;
import cc.g1cloud.greenhousessid31.controller.dto.response.TelemetryWidgetSingleDto;
import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;

import java.util.List;

public interface GreenhouseService {

    PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange(String deviceID, String from, String to);
    List<TelemetryDtoV2> findTelemetryRangeV2(String deviceID, String from, String to);
    TelemetryWidgetSingleDto findTelemetryWidgetSingle(String deviceID, Long range);
}
