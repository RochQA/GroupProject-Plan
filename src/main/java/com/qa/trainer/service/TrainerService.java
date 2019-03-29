package com.qa.trainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.trainer.entities.Trainer;
import com.qa.trainer.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository repo;

	private Trainer trainer;

	public TrainerService(TrainerRepository repo) {
		this.repo = repo;
	}

	public Trainer createTrainer(Trainer trainer) {
		return repo.save(trainer);
	}

	public String deleteTrainer(Long id) {
		this.repo.deleteById(id);
		return "Trainer deleted";
	}

	public List<Trainer> getAllTrainers() {
		return repo.findAll();
	}

	public Trainer getTrainer(Long id) {
		List<Trainer> allTrainers = getAllTrainers();
		trainer = null;
		allTrainers.stream().forEach(a -> {
			if (a.getId().equals(id)) {
				trainer = a;
			}
		});
		return trainer;
	}

}
