package me.answer.answerme.controllers;

import me.answer.answerme.models.Question;
import me.answer.answerme.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/questions")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @GetMapping
  public ResponseEntity<List<Question>> getAll() {
    var questions = questionService.findAll();

    return ResponseEntity.status(HttpStatus.OK).body(questions);
  }

  @GetMapping("{id}")
  public ResponseEntity<Question> getById(@PathVariable Integer id) {
    var question = questionService.findById(id);

    if (question == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(question);
  }

  @PostMapping
  public ResponseEntity<Question> create(@RequestBody Question q) {
    var question = questionService.save(q);
    return ResponseEntity.status(HttpStatus.CREATED).body(question);
  }
}
