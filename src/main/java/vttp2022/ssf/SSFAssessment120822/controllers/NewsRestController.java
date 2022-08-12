package vttp2022.ssf.SSFAssessment120822.controllers;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2022.ssf.SSFAssessment120822.repositories.NewsRepository;
import vttp2022.ssf.SSFAssessment120822.services.NewsService;

@RestController
// produces ---> ACCEPT: 
@RequestMapping(path="/news/{id}" consumes= APPLICATION_JSON)
public class NewsRestController {
    
    // INJECT SERVICE
    @Autowired
    private NewsService newsSvc;

    @Autowired
    private NewsRepository newsRepo;

    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getNewsAsJson(@RequestParam 
    (name="article", defaultValue="") String id) {
                  // CONSTRUCT ERROR OBJECT
                  boolean isfound;
                if (id != isfound) {
                    JsonObject errResp = Json
                            .createObjectBuilder()
                            .add("error", "cannot find news article".formatted(id))
                            .build();
                    String payload = errResp.toString();
                    // Return 400
                    return ResponseEntity
                            //.status(HttpStatus.BAD_REQUEST) 
                            .badRequest() //400
                            .body(payload);
    }
}
}