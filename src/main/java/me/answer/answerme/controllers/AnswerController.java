package me.answer.answerme.controllers;

import me.answer.answerme.models.Answer;
import me.answer.answerme.services.AnswerService;
import me.answer.answerme.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/answers")
public class AnswerController {

  @Autowired
  private AnswerService answerService;

  @Autowired
  private QuestionService questionService;

  @PostMapping("{questionId}")
  public ResponseEntity<Answer> create(@PathVariable Integer questionId, @RequestBody Answer answer) {
    var question = questionService.findById(questionId);

    answer.setQuestion(question);
    var newAnswer = answerService.save(answer);

    return ResponseEntity.status(HttpStatus.CREATED).body(newAnswer);
  }
}
