package com.example.goodnightworld.Services;

import tools.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dynamic-receiver", url = "${feign.client.config.dynamic-receiver.url:http://localhost:8083/response}")
public interface PassthroughClient {

    // Accepts ANY object as input, returns generic JsonNode from receiver
    @PostMapping
    JsonNode sendDynamicData(@RequestBody Object anyObject);
}
