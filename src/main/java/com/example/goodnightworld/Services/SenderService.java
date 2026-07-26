package com.example.goodnightworld.Services;

import com.example.goodnightworld.model.Snack;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.JsonNode;
import com.example.goodnightworld.Services.PassthroughClient;

@Service
public class SenderService {
    private final PassthroughClient passthroughClient;

    // Spring automatically injects the Feign Client implementation here
    public SenderService(PassthroughClient passthroughClient) {
        this.passthroughClient = passthroughClient;
    }
    public void shipExistingObject() {
        // 1. Instantiate your pre-existing object
//        ExistingOrder myOrder = new Snack();
        Snack light = new Snack();
        System.out.println("Sender: Shipping existing object directly...");

        // 2. Pass it directly. No maps, no manual conversions.
        JsonNode responseBody = passthroughClient.sendDynamicData(light);

        // 3. Print the echo response from the generic receiver
        System.out.println("Sender: Received response: " + responseBody.toString());
    }

}
