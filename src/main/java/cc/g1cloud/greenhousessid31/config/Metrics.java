package cc.g1cloud.greenhousessid31.config;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Metrics {

    private final MeterRegistry meterRegistry;

    public void countDBCallTelemetry(Integer value) {
        meterRegistry.counter("count_db_call_telemetry").increment(value);
    }

}
