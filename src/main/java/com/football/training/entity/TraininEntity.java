package com.football.training.entity;

import com.football.training.enums.TrainingDay;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "training")
public class TraininEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_training")
  private long id_training;

  @Column(name = "training_day")
  private TrainingDay training_day;
  
}
