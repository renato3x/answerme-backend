package me.answer.answerme.repositories;

import me.answer.answerme.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository  extends JpaRepository<Answer, Integer> {
}
