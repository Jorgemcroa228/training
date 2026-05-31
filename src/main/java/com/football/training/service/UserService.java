package com.football.training.service;

import org.springframework.stereotype.Service;

import com.football.training.dto.request.UserRequestDTO;
import com.football.training.dto.response.UserResponseDTO;
import com.football.training.entity.UserEntity;
import com.football.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  // in thi part, put this code : private final PasswordEncoder;

  public UserResponseDTO createUser(UserRequestDTO request){

    if (userRepository.existsByEmail(request.getEmail())) {
      throw new RuntimeException("Email existing, write a new Email.");
    }
    
    UserEntity users = new UserEntity();

    users.setName(request.getName());
    users.setEmail(request.getEmail());
    users.setPassword(request.getPassword());
    users.setRole(request.getRole());

    UserEntity saveUsers = userRepository.save(users);
    return toResponse(saveUsers);

    public list<UserRequestDTO> listUser(){
      return userRepository.findAll().stream().map(this:: toResponse).toList();
    }

    public UserResponseDTO 

    public UserResponseDTO toResponse(UserEntity users){
      return UserResponseDTO.builder()
            .id_user(users.getId_user())
            .name(users.getName())
            .email(users.getEmail())
            .password(users.getPassword())
            .role(users.getRole())
            .build();
    }
}
