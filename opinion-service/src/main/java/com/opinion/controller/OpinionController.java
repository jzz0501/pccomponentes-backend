package com.opinion.controller;

import com.data.opinion.Opinion;
import com.data.opinion.OpinionDTO;
import com.opinion.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("/api/opinion")
public class OpinionController {

    @Autowired
    OpinionService opinionService;

    @PostMapping
    public OpinionDTO postOpinion(@RequestBody Opinion opinion) {
        opinion.setCreatedDate(LocalDateTime.now().toString());
        return opinionService.addOpinion(opinion);
    }

    @DeleteMapping("/{id_opinion}")
    public void deleteOpinion(@PathVariable("id_opinion") Long id_client) {
        opinionService.removeOpinionById(id_client);
    }

}