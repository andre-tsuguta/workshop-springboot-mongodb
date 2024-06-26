package com.andretsuguta.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andretsuguta.workshopmongo.domain.Post;
import com.andretsuguta.workshopmongo.repositories.PostRepository;
import com.andretsuguta.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto Nao encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
	public List<Post> searchWithParms(String text, Date dateMin, Date dateMax){
		dateMax = new Date(dateMax.getTime() + 24 * 60 * 60 * 1000);
		return repository.searchWithParms(text, dateMin, dateMax);
	}

}
