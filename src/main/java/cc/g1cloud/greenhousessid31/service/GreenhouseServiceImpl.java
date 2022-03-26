package cc.g1cloud.greenhousessid31.service;

import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import cc.g1cloud.greenhousessid31.repository.GreenhouseRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GreenhouseServiceImpl implements GreenhouseService {

    private final GreenhouseRepository greenhouseRepository;

    @Override
    public PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange(String deviceID, String from, String to) {
        return greenhouseRepository.findTelemetryRange(deviceID, from, to);
    }


}
