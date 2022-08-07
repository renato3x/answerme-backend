package me.answer.answerme.services;

import me.answer.answerme.models.Question;
import me.answer.answerme.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {

  @Autowired
  private QuestionRepository questionRepository;

  public List<Question> findAll() {
    return questionRepository.findAll();
  }

  public Question findById(Integer id) {
    return questionRepository.findById(id).orElse(null);
  }

  public Question save(Question q) {
    q.setId(null);
    return questionRepository.save(q);
  }

  public Question edit(Question q) {
    return questionRepository.save(q);
  }

  public void delete(Integer id) {
    questionRepository.deleteById(id);
  }
}
