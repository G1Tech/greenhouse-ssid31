**Чтобы добавить пароль в Baisic Authority bcrypt - надо установить spring-cli**
- https://docs.spring.io/spring-security/reference/5.6.0-RC1/servlet/authentication/passwords/in-memory.html
- https://docs.spring.io/spring-security/reference/5.6.0-RC1/features/authentication/password-storage.html#authentication-password-storage-boot-cli
- spring encodepassword password
```
.password("{bcrypt}$2a$10$JdiiMxvGECMXOfPnFFu/YeNtQxzmeNgCvv25MO4n0llMZLf78DVu6")
.password("{noop}XbU#M")
```
```
D:\spring-2.6.6\bin>spring encodepassword XbU#M
{bcrypt}$2a$10$JdiiMxvGECMXOfPnFFu/YeNtQxzmeNgCvv25MO4n0llMZLf78DVu6
```

**Варианты получения метрик**
- https://prometheus.io/docs/concepts/metric_types/#gauge

**Кастомизация swagger**
```
    @GetMapping("/telemetry/range")
    @Operation(summary = "Get telemetry by range")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Successfully"),
    @ApiResponse(responseCode = "500", description = "Incorrect request", content = @Content)})
    public PaginatedQueryList<GreenhouseTelemetry> findTelemetryRange
    (@RequestParam
    @Parameter(description = "Device ID") @PathParam("deviceId") String deviceId, String from, String to) {
    log.debug("Input params deviceId:{}, from:{}, to:{}", deviceId, from, to);
    return greenhouseService.findTelemetryRange(deviceId, from, to);
    }

```
