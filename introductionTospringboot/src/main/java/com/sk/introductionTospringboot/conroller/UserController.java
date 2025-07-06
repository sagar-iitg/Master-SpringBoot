package com.sk.introductionTospringboot.conroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class UserController {


    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @GetMapping("get-user")
    public ResponseEntity<String> getUser() throws JsonProcessingException {
        log.info("inside get-user method");
        ObjectMapper obj=new ObjectMapper();
        obj.configure(com.fasterxml.jackson.core.JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
        //String str="hello world";
        // This is technically invalid JSON if quotes are disabled
        Map<String, String> invalid = Map.of("invalidKey", "value");
        String s = obj.writeValueAsString(invalid);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(s);
    }

    @GetMapping("new-user")
    public ResponseEntity<String> getUserError(){
         throw new RuntimeException("null pointer");
    }
    @GetMapping("get-user2")
    public ResponseEntity<String> getUser2() throws JsonProcessingException {
        throw new JsonProcessingException("Forced for testing") {};
    }

        @PostMapping(value="get-user3",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUser3() throws JsonProcessingException {
        log.info("inside get-use3 method");
        ObjectMapper obj=new ObjectMapper();
        String str="heello world";
       String s = obj.writeValueAsString(str);


        return ResponseEntity.status(HttpStatus.OK).body(s);

    }

    @GetMapping(value="get-user4",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUser4() throws JsonProcessingException {
        log.info("inside get-use3 method");
        HttpHeaders headers=new HttpHeaders();
        headers.set("X-sagar","kumar");
        headers.set("X-mohit","kumar");
        String str="hello world";
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(str);

    }


}
