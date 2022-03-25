package cc.g1cloud.greenhousessid31.controler;

import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import cc.g1cloud.greenhousessid31.repository.GreenhouseTelemetryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class GreenhouseControler {

    private final GreenhouseTelemetryRepository greenhouseTelemetryRepository;


    @GetMapping("/employee/{id}")
    public GreenhouseTelemetry getEmployee(@PathVariable("id") long employeeId) {
        return greenhouseTelemetryRepository.getEmployeeById(employeeId);
    }
}



