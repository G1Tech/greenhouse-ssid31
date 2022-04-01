package cc.g1cloud.greenhousessid31.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class    ErrorResponseDto {

    private UUID uuid;
    private Long data;
    private String errors;

}
