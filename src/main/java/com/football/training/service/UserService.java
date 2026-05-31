package com.football.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.football.training.config.PasswordConfig;
import com.football.training.config.PasswordConfig;
import com.football.training.dto.request.UserRequestDTO;
import com.football.training.dto.response.DeleteUserResponseDTO;
import com.football.training.dto.response.UserResponseDTO;
import com.football.training.entity.UserEntity;
import com.football.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final PasswordConfig passwordConfig;

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
  }
    public List<UserResponseDTO> listUser(){
      return userRepository.findAll().stream().map(this:: toResponse).toList();
    }

    public UserResponseDTO showById(Long id_user){
      UserEntity users = userRepository.findById(id_user).orElseThrow(() -> new RuntimeException("User not found."));
      return toResponse(users);
    }

    public UserResponseDTO updateById(Long id_user, UserRequestDTO request) {
      UserEntity users = userRepository.findById(id_user).orElseThrow(()-> new RuntimeException("User not found."));
      
      users.setName(request.getName());
      users.setEmail(request.getEmail());
      users.setPassword(request.getPassword());
      users.setRole(request.getRole());

      UserEntity saveUsers = userRepository.save(users);

      return toResponse(saveUsers);
    }

    public DeleteUserResponseDTO deltedUserById(Long id_user){
      userRepository.findById(id_user).orElseThrow(() -> new RuntimeException("User not found"));
      userRepository.deleteById(id_user);

      return DeleteUserResponseDTO.builder()
              .message("User deleted successfully.")
              .build();
    }

    public UserResponseDTO toResponse(UserEntity users){
      return UserResponseDTO.builder()
            .id_user(users.getId_user())
            .name(users.getName())
            .email(users.getEmail())
            .role(users.getRole())
            .build();
    }
}
