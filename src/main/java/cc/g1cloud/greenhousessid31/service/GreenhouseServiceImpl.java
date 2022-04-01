package cc.g1cloud.greenhousessid31.service;

import cc.g1cloud.greenhousessid31.controller.dto.TelemetryDtoV2;
import cc.g1cloud.greenhousessid31.controller.dto.TelemetryWidgetSingleDto;
import cc.g1cloud.greenhousessid31.domain.GreenhouseTelemetry;
import cc.g1cloud.greenhousessid31.mapper.GreenhouseTelemetryMapper;
import cc.g1cloud.greenhousessid31.repository.GreenhouseRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@AllArgsConstructor
public class GreenhouseServiceImpl implements GreenhouseService {

    private final GreenhouseRepository greenhouseRepository;
    private final GreenhouseTelemetryMapper greenhouseTelemetryMapper;

    @Override
    public PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange(String deviceID, String from, String to) {
        return greenhouseRepository.findTelemetryRange(deviceID, from, to);
    }

    @Override
    public List<TelemetryDtoV2> findTelemetryRangeV2(String deviceID, String from, String to) {
        List<GreenhouseTelemetry> greenhouseTelemetryList = greenhouseRepository.findTelemetryRange(deviceID, from, to);
        return greenhouseTelemetryList.stream().map(greenhouseTelemetryMapper::toDtoV2).collect(Collectors.toList());
    }

    @Override
    public TelemetryWidgetSingleDto findTelemetryWidgetSingle(String deviceID, Long range) {
        return greenhouseTelemetryMapper.toWidgetSingleDto(greenhouseRepository.findTelemetryRange(deviceID, Long.toString(System.currentTimeMillis() - range), Long.toString(System.currentTimeMillis())));

    }


}
