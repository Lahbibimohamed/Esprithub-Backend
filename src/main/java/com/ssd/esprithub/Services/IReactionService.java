package com.ssd.esprithub.Services;

import java.util.List;

import com.ssd.esprithub.entity.Reaction;





public interface IReactionService {
	
	Reaction addReaction (Reaction r);
	List<Reaction> retrieveReactions();

	

	void deleteReaction(Long id);

	Reaction updateReaction(Reaction r);

	Reaction retrieveReaction(Long id);

}
