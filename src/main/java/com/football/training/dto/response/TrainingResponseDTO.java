package com.football.training.dto.response;

import com.football.training.enums.TrainingDay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TrainingResponseDTO {
    
    private Long id;
    private TrainingDay training_day;
}
