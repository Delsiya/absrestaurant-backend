package com.abcrestaurant.abcrestaurant.Controller;

import com.abcrestaurant.abcrestaurant.Entity.Query;
import com.abcrestaurant.abcrestaurant.Repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queries")
@CrossOrigin(origins = "http://localhost:3000")
public class QueryController {

    @Autowired
    private QueryRepository queryRepository;

    @PostMapping("/create")
    public ResponseEntity<String> submitQuery(@RequestBody @Validated Query query) {
        // No need for explicit validation here, handled by @Valid
        queryRepository.save(query);
        return new ResponseEntity<>("Query submitted successfully", HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<Query>> getAllQueries() {
        try {
            List<Query> queries = queryRepository.findAll();
            return new ResponseEntity<>(queries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
