package com.example.goodnightworld.Controllers;

import com.example.goodnightworld.Services.GoodNight;
import com.example.goodnightworld.Services.PassthroughClient;
//import com.example.goodnightworld.Services.SenderService;
import com.example.goodnightworld.model.Snack;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.JsonNode;


@RestController
public class GoodNightController {
//    @Autowired
    GoodNight night;
//    @Autowired
//    SenderService senderService;

    private final PassthroughClient passthroughClient;
    public GoodNightController(PassthroughClient passthroughClient) {
        this.passthroughClient = passthroughClient;
    }
    @GetMapping({"/", "/home"})
    public String home(){
        return "nightTime";
    }
//    @GetMapping("/night")
//    public String goodNight() {
//        night.goodNight();
//
//        return "Time for Bed~";
//    }
    @GetMapping("/night")
    public String goodNight() {
        boolean isAsleep = night.goodNight();
        return isAsleep ? "Time for Bed~" : "Rise and shine!";
    }

//    @GetMapping("/fat")
//    public Snack snackTime(){
////        Snack diabetes = new Snack();
//        return new Snack();
//    }

    @GetMapping("/fat")
    public Snack snackTime(@RequestParam(defaultValue = "cookies") String name) {
        Snack snack = new Snack();
        snack.setName(name);
        snack.setBedtimeSafe(night.isBedtimeSafe(name));
        return snack;
    }
    /** General Case, sending a general json object via taking a json input
     * and returning it as the output
     **/


    @ResponseBody
    @PostMapping(value="/snack", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> sendSnack(@RequestBody Object anyObject){
        JsonNode receiverResponse = passthroughClient.sendDynamicData(anyObject);
        return ResponseEntity.ok(receiverResponse);
    }

    /** General Case, sending a general json object via taking a json input
     * and returning a different one as the output
     **/
//    @ResponseBody
//    @PostMapping(value="/snack", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<JsonNode> sendSnack(@RequestBody Object anyObject){
//        JsonNode receiverResponse = passthroughClient.sendDynamicData(new Snack());
//        return ResponseEntity.ok(receiverResponse);
//    }

    /** General Case, sending a general json object
     **/
    @ResponseBody
    @GetMapping(value = "/snack", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> sendSnack() {

        JsonNode receiverResponse = passthroughClient.sendDynamicData(new Snack());
        return ResponseEntity.ok(receiverResponse);
    }


}
