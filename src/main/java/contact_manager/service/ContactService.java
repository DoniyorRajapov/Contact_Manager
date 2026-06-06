package contact_manager.service;

import contact_manager.dto.ContactDto;
import contact_manager.entity.ContactEntity;
import contact_manager.entity.ProfileEntity;
import contact_manager.exception.NotFoundException;
import contact_manager.repository.ContactRepository;
import contact_manager.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    @Autowired
    private ProfileRepository profileRepository;

    public ContactDto create(ContactDto dto){
        ContactEntity entity = mapToEntity(dto);
        entity.setProfile(profile());
        dto.setId(repository.save(entity).getId());
        return dto;
    }

    public List<ContactDto> findAll(){
        return repository.findByProfile(profile()).stream().map(this::mapToDto).toList();
    }

    public ContactDto findById(UUID id){
        return mapToDto(findContact(id));
    }

    public ContactDto update(UUID id, ContactDto dto){
        ContactEntity entity = findContact(id);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        repository.save(entity);

        dto.setId(id);
        return dto;
    }

    public Boolean delete(UUID id){
        repository.delete(findContact(id));
        return true;
    }

    public Boolean deleteAll(){
        repository.deleteByProfile(profile());
        return true;
    }

    public List<ContactDto> search(String st){
       return repository.search(st,profile()).stream().map(this::mapToDto).toList();
    }

    private ContactEntity mapToEntity(ContactDto dto){
        ContactEntity entity = new ContactEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    private ContactDto mapToDto(ContactEntity entity){
        ContactDto dto = new ContactDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    private ProfileEntity profile(){
        return profileRepository.findByUsername(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName())
                .orElseThrow(()-> new NotFoundException("Profile not found"));
    }

    private ContactEntity findContact(UUID id){
        return repository.findByIdAndProfile(id,profile())
                .orElseThrow(()-> new NotFoundException("Contact not found"));
    }
}