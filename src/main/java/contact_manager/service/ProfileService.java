package contact_manager.service;

import contact_manager.dto.ProfileDto;
import contact_manager.entity.ProfileEntity;
import contact_manager.exception.AlreadyExistsException;
import contact_manager.exception.NotFoundException;
import contact_manager.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(ProfileDto dto){
        if(repository.existsByUsername(dto.getUsername())){
            throw new AlreadyExistsException("Username already exists");
        }
        repository.save(mapToEntity(dto));

        return "Registration successful";
    }

    public String login(ProfileDto dto){
        ProfileEntity entity = repository.findByUsername(dto.getUsername())
                .orElseThrow(()->new NotFoundException("User or password not found"));
        if (!passwordEncoder.matches(dto.getPassword(), entity.getPassword()))
            throw new NotFoundException("User or password not found");
        return "Login successful!";
    }

    private ProfileEntity mapToEntity(ProfileDto dto){
        ProfileEntity entity = new ProfileEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        return entity;
    }
}