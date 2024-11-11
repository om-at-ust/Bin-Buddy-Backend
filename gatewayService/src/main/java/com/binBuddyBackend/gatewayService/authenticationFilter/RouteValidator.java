package com.binBuddyBackend.gatewayService.authenticationFilter;



import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    // list of urls to be ignored by the api-gateway filter
    public static final List<String> openApiEndpoints = List.of(
            "/register",
            "/login",
            "/validate/token",
            "/getbook",
            "/getauthors");
    public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints
            .stream()
            .noneMatch(uri -> request
                    .getURI()
                    .getPath()
                    .contains(uri));
}