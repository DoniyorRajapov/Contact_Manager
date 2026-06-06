package contact_manager.repository;

import contact_manager.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository extends CrudRepository<ProfileEntity, UUID> {
    Optional<ProfileEntity> findByUsername(String username);

    Boolean existsByUsername(String username);
}