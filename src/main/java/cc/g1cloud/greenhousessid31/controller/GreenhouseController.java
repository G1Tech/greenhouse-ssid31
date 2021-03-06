package cc.g1cloud.greenhousessid31.controller;

import cc.g1cloud.greenhousessid31.controller.dto.response.TelemetryResponseDtoV2;
import cc.g1cloud.greenhousessid31.controller.dto.response.TelemetryWidgetSingleResponseDto;
import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import cc.g1cloud.greenhousessid31.service.GreenhouseService;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class GreenhouseController {

    private final GreenhouseService greenhouseService;

    @GetMapping("/telemetry/range")
    public PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange(@RequestParam String deviceId, String from, String to) {
        log.debug("Input params deviceId:{}, from:{}, to:{}", deviceId, from, to);
        return greenhouseService.findTelemetryRange(deviceId, from, to);
    }

    @GetMapping("/v2/telemetry/range")
    public List<TelemetryResponseDtoV2> findTelemetryRangeV2(@RequestParam String deviceId, String from, String to) {
        log.debug("Input params deviceId:{}, from:{}, to:{}", deviceId, from, to);
        return greenhouseService.findTelemetryRangeV2(deviceId, from, to);
    }

    @GetMapping("/telemetry/widger/single")
    public TelemetryWidgetSingleResponseDto findTelemetryWidgetSingle(@RequestParam String deviceId, Long range) {
        log.debug("Input params deviceId:{}, range:{}", deviceId, range);
        return greenhouseService.findTelemetryWidgetSingle(deviceId, range);
    }


}



