package com.qa.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.trainer.entities.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
