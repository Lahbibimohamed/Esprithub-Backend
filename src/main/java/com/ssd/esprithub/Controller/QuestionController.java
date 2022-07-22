package com.ssd.esprithub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssd.esprithub.Services.QuestionServiceImp;
import com.ssd.esprithub.entity.Question;

public class QuestionController {
	
	@Autowired
	private QuestionServiceImp questionservice;
	
	
	@PostMapping("/addQuestion")
	@ResponseBody
	public Question addQuestion(@RequestBody Question question) {
		return questionservice.addQuestion(question);
	}
	
	@PutMapping("/updateQuestion")
	@ResponseBody
	public Question updateQuestion(@RequestBody Question question) {
		return questionservice.updateProduit(question);
	}
	
	@GetMapping("Question")
	@ResponseBody
	public Question retrieveQuestion(@RequestParam("id") Long id) {
		return questionservice.retrieveQuestion(id);
	}
	
	@GetMapping("/Questions")
	@ResponseBody
	public List<Question> retrieveQuestions(){
		return questionservice.retrieveQuestions();
	}

}
