package cc.g1cloud.greenhousessid31.controller;

import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import cc.g1cloud.greenhousessid31.service.GreenhouseService;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GreenhouseController {

    private final GreenhouseService greenhouseService;

    @GetMapping("/telemetry/range")
    public PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange(@RequestParam String deviceId, @RequestParam String from, @RequestParam String to) {
        return greenhouseService.findTelemetryRange(deviceId, from, to);
    }


}



