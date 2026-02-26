package com.tracemeds.indent_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(
        name = "TenantService",
        url = "http://localhost:8080"
)
public interface TenantClient {
    @GetMapping("/api/v1/tenant/isRegistered")
    Boolean checkTenant(@RequestParam("tenantCode") String tenantCode);
}
