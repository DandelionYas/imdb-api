package com.imdb.api.controllers;

import com.imdb.api.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/administration")
public class AdminController {
    private final AdminService adminService;

    @Operation(summary = "Get count of http requests",
            description = "Returns the current count of http requests since the last startup")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned count of http requests")})
    @GetMapping("/requests-count")
    public Long findTitlesWithSameAndAliveCrew() {
        return adminService.getRequestCount();
    }
}
