package erick.br.services;

import com.desafio.vaga.entities.User;

import erick.br.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAllOrderedByName();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User validation(Long id) {
        Optional<User> userValidation = userRepository.findById(id);

        if(userValidation.get().isStatus() == true) {
            userValidation.get().setStatus(false);
        } else {
            userValidation.get().setStatus(true);
        }

        return userRepository.save(userValidation.get());
    }

}
