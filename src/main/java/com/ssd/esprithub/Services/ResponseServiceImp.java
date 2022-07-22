package com.ssd.esprithub.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssd.esprithub.Repositories.ReponseRepository;
import com.ssd.esprithub.entity.Response;

public class ResponseServiceImp implements IResponseService {
	@Autowired
	private ReponseRepository reponseRepository;

	@Override
	public Response addResponse(Response r) {
	return	reponseRepository.save(r);
	}

	@Override
	public List<Response> retrieveResponses() {
		return (List<Response>) reponseRepository.findAll();
	}

	@Override
	public void deleteResponse(Long id) {
		reponseRepository.deleteById(id);
		
	}

	@Override
	public Response updateResponse(Response u) {
		return reponseRepository.save(u);
	}

	@Override
	public Response retrieveResponse(Long id) {
		return reponseRepository.findById(id).orElse(null);
	}

}
