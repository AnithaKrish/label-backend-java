package com.example.demo.controller;

import com.example.demo.model.Label;
import com.example.demo.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public Label addLabel(@RequestBody Label label){
       return labelService.addLabel(label);
    }

    @GetMapping(path="/all")
    public List<Label> getLabels(){
       return labelService.getLabels();
    }

}

