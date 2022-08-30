package com.ssd.esprithub.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssd.esprithub.Repositories.ReactionRepository;
import com.ssd.esprithub.entity.Reaction;



public class ReactionServiceImp implements IReactionService {

	
	@Autowired
	private ReactionRepository reactionRepository;
	@Override
	public Reaction addReaction(Reaction r) {
		r.setDate(new Date());
		return reactionRepository.save(r);
	}

	@Override
	public List<Reaction> retrieveReactions() {
		return (List<Reaction>) reactionRepository.findAll();
	}

	@Override
	public void deleteReaction(Long id) {
		reactionRepository.deleteById(id);
		
	}

	@Override
	public Reaction updateReaction(Reaction r) {
		return reactionRepository.save(r);
		}

	@Override
	public Reaction retrieveReaction(Long id) {
		return reactionRepository.findById(id).orElse(null);
	}

	
}
