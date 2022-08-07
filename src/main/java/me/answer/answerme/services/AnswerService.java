package me.answer.answerme.services;

import me.answer.answerme.models.Answer;
import me.answer.answerme.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AnswerService {

  @Autowired
  private AnswerRepository answerRepository;

  public List<Answer> findAll() {
    return answerRepository.findAll();
  }

  public Answer findById(Integer id) {
    return answerRepository.findById(id).orElse(null);
  }

  public Answer save(Answer q) {
    q.setId(null);
    return answerRepository.save(q);
  }

  public Answer edit(Answer q) {
    return answerRepository.save(q);
  }

  public void delete(Integer id) {
    answerRepository.deleteById(id);
  }
}
