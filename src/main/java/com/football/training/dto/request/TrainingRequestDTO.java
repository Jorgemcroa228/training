package com.football.training.dto.request;

import com.football.training.enums.TrainingDay;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// is necesary to see or ask to IA that @Column have everything good and sharing SQL and Entity too.

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrainingRequestDTO {

    @NotBlank(message = "this field is required.")
    @Column(name = "id")
    private long id_training;

    @NotBlank(message = "this field is required.")
    @Column(name = "training_day")
    private TrainingDay training_day;
}
