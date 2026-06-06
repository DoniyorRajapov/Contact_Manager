package contact_manager.controller;

import contact_manager.dto.ContactDto;
import contact_manager.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    public ResponseEntity<ContactDto> create(@Valid @RequestBody ContactDto dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDto> findById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> update(@PathVariable("id") UUID id,@Valid @RequestBody ContactDto dto){
        return ResponseEntity.ok(service.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.delete(id));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAll(){
        return ResponseEntity.ok(service.deleteAll());
    }

    @GetMapping("/search/{st}")
    public ResponseEntity<List<ContactDto>> search(@PathVariable("st") String st){
        return ResponseEntity.ok(service.search(st));
    }
}