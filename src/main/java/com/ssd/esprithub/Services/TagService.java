package com.ssd.esprithub.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssd.esprithub.Repositories.TagRepository;
import com.ssd.esprithub.entity.Tag;

public class TagService implements ITagService{

	@Autowired 
	private TagRepository tagrepository;
	@Override
	public Tag addTag(Tag q) {
		return tagrepository.save(q); 
	}

	@Override
	public List<Tag> retrieveTags() {
		return (List<Tag>) tagrepository.findAll();
	}

	@Override
	public void deleteTag(Long id) {
		tagrepository.deleteById(id);
		
	}

	@Override
	public Tag updateTag(Tag u) {
		return tagrepository.save(u);
	}

	@Override
	public Tag retrieveTag(Long id) {
		return tagrepository.findById(id).get();
	}

}
