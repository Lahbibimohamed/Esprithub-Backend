package com.ssd.esprithub.Services;

import java.util.List;

import com.ssd.esprithub.entity.Question;





public interface QuestionService {

	
	List<Question> retrieveQuestions();

	

	void deleteQuestion(Long id);

	Question updateProduit(Question u);

	Question retrieveQuestion(Long id);
}
