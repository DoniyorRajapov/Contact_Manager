package contact_manager.controller;

import contact_manager.dto.ProfileDto;
import contact_manager.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ProfileController {
    @Autowired
    private ProfileService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody ProfileDto dto){
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody ProfileDto dto){
        return ResponseEntity.ok(service.login(dto));
    }
}