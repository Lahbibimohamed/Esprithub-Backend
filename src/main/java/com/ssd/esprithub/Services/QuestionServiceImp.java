package com.ssd.esprithub.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssd.esprithub.Repositories.QuestionRepository;
import com.ssd.esprithub.entity.Question;

public class QuestionServiceImp implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question q) {
		return questionRepository.save(q);
	}

	@Override
	public List<Question> retrieveQuestions() {
		return (List<Question>) questionRepository.findAll();
	}

	@Override
	public void deleteQuestion(Long id) {
		questionRepository.deleteById(id);
	}

	@Override
	public Question updateProduit(Question u) {
		return questionRepository.save(u);
	}

	@Override
	public Question retrieveQuestion(Long id) {
		return questionRepository.findById(id).orElse(null);
	}

}
