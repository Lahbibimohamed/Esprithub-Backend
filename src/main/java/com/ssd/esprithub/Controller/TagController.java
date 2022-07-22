package com.ssd.esprithub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssd.esprithub.Services.TagService;
import com.ssd.esprithub.entity.Tag;

public class TagController {

	@Autowired
	private TagService tagservice;
	
	@PostMapping("/addTag")
	@ResponseBody
	public Tag addTag(@RequestBody Tag tag) {
		return tagservice.addTag(tag);
	}
	
	@PutMapping("/updateTag")
	@ResponseBody
	public Tag updateTag(@RequestBody Tag tag) {
		return tagservice.updateTag(tag);
	}
	
	@GetMapping("/Tag")
	@ResponseBody
	public Tag getTag(@RequestParam("id") Long id ) {
		return tagservice.retrieveTag(id);
	}
	
	@GetMapping("/Tags")
	@ResponseBody
	public List<Tag> getTags(){
		return tagservice.retrieveTags();
	}
	
}
