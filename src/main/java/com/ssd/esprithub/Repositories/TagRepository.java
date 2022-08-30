package com.ssd.esprithub.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssd.esprithub.entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findByTitle(String title);

}
