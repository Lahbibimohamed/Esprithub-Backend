package com.ssd.esprithub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssd.esprithub.Services.ResponseServiceImp;
import com.ssd.esprithub.entity.Response;

public class ResponseController {

	@Autowired
	private ResponseServiceImp responseServiceImp;
	
	@PostMapping("/addResponse")
	@ResponseBody
	public Response addResponse(@RequestBody Response response) {
		return responseServiceImp.addResponse(response);
	}
	
	@PutMapping("/updateResponse")
	@ResponseBody
	public Response updateResponse(@RequestBody Response response) {
		return responseServiceImp.updateResponse(response);
	}
	
	@GetMapping("/Response")
	@ResponseBody
	public Response getResponse(@RequestParam("id") Long id) {
		return responseServiceImp.retrieveResponse(id);
	}
	
	@GetMapping("/Responses")
	@ResponseBody
	public List<Response> getResponses(){
		return responseServiceImp.retrieveResponses();
	}
}
