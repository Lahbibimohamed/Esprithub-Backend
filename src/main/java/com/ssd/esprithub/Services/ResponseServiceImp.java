package com.ssd.esprithub.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssd.esprithub.Repositories.QuestionRepository;
import com.ssd.esprithub.Repositories.UserRepository;





@Service
public class ResponseServiceImp implements IResponseService {
	@Autowired
	private ResponseRepository responseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Response addResponse(Response r) {
		r.setDatepub(new Date());
		r.setApproved(0);
	return	responseRepository.save(r);
	}

	@Override
	public List<Response> retrieveResponses() {
		return (List<Response>) responseRepository.findAll();
	}

	@Override
	public void deleteResponse(Long id) {
		responseRepository.deleteById(id);
		
	}

	@Override
	public Response updateResponse(Response u) {
		return responseRepository.save(u);
	}

	@Override
	public Response retrieveResponse(Long id) {
		return responseRepository.findById(id).orElse(null);
	}
	
	public List<UserQuestion> getQuestionAnswers(Long id){
		List<UserQuestion> result=new ArrayList<>();
		Question question=questionRepository.findById(id).get();
		User user=question.getUserquestions();
		String nom=user.getFirstName()+" "+user.getLastName();
		
		
		for (Response response : question.getQuestionresponse()) {
			
			if(response.getApproved()==1 || response.getApproved()==2)
			result.add(new UserQuestion(response.getIdResponse(),nom, response.getContent(), response.getDatepub(),"", 0, user.getRole().toString(),AffectBadge(response.getIdUser())));

		}
		
		
		
	
		return result;
	}
	
	
	
	public List<UserQuestion> getQuestionAnswersNotApproved(Long id){
		List<UserQuestion> result=new ArrayList<>();
		Question question=questionRepository.findById(id).get();
		User user=question.getUserquestions();
		String nom=user.getFirstName()+" "+user.getLastName();
		
		
		for (Response response : question.getQuestionresponse()) {
			
			if(response.getApproved()==0)
			result.add(new UserQuestion(response.getIdResponse(), nom, response.getContent(), response.getDatepub(),"", 0, user.getRole().toString(),AffectBadge(response.getIdUser())));

		}
		
		
		
	
		return result;
	}
	
	public void ApproveAnswer(Long id) {
		Response response=responseRepository.findById(id).get();
		response.setApproved(1);
		responseRepository.save(response);
	}
	
	public void CancelAnswer(Long id) {
		responseRepository.deleteById(id);
	}
	
	public void CommentAnswer(Long id) {
		Response response=responseRepository.findById(id).get();
		response.setApproved(2);
		responseRepository.save(response);
	}
	
	public float getRightAnswerPerCent(Long id) {
		List<Response> responses=responseRepository.findByIdUser(id);
		int nbrRight=0;
		int nbTotal=0;
		for (Response response : responses) {
			if(response.getApproved()==1)
				nbrRight++;
			if(response.getApproved()==1 || response.getApproved()==2)
				nbTotal++;
		}
		
		return (nbrRight/nbTotal)*100;
	}
	
	public TypeBadge AffectBadge(Long id) {
		float p=getRightAnswerPerCent(id);
		if(p >= 70)
			return TypeBadge.gold;
		else if(p >=50)
			return TypeBadge.silver;
		else if(p>= 30)
			return TypeBadge.bronze;
		else 
			return null;
	}
	

}
