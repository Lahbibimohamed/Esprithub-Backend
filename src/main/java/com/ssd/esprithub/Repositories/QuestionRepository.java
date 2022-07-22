package com.ssd.esprithub.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.ssd.esprithub.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
