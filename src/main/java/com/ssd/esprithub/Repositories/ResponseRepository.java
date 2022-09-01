package com.ssd.esprithub.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssd.esprithub.entity.Response;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {

	List<Response> findByIdUser(Long id);
}
