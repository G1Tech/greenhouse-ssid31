package cc.g1cloud.greenhousessid31.controller;

import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import cc.g1cloud.greenhousessid31.repository.GreenhouseTelemetryRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GreenhouseController {

    private final GreenhouseTelemetryRepository greenhouseTelemetryRepository;


    @GetMapping("/employee/{id}")
    public GreenhouseTelemetry getEmployee(@PathVariable("id") long employeeId) {
        return greenhouseTelemetryRepository.getEmployeeById(employeeId);
    }

    @GetMapping("/telemetry")
    public List<GreenhouseTelemetry> getAll() {
        return greenhouseTelemetryRepository.findAll();
    }


    @GetMapping("/telemetry2")
    public PaginatedQueryList<GreenhouseTelemetry> getAll2() {
        return greenhouseTelemetryRepository.findAll2("espBL", "1648295439556", "1648295530161");
    }


}



