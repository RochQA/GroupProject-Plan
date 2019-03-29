package com.qa.trainer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.trainer.entities.Trainer;
import com.qa.trainer.service.TrainerService;

@RestController
public class TrainerController {

	public TrainerService svc;

	public TrainerController(TrainerService svc) {
		this.svc = svc;
	}
	
	@PostMapping("/createTrainer")
	public Trainer createTrainer(Trainer trainer) {
		return svc.createTrainer(trainer);
	}
	
	@DeleteMapping("/deleteTrainer/{id}")
	public String deleteTrainer(@PathVariable Long id) {
		return svc.deleteTrainer(id);
	}
	
	@GetMapping("/getTrainer")
	public List<Trainer> getAllTrainers(){
		return svc.getAllTrainers();
	}
	
	@GetMapping("/getTrainer/{id}")
	public Trainer getTrainer(@PathVariable Long id) {
		return svc.getTrainer(id);
	}

}
