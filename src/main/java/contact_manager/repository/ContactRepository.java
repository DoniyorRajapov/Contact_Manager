package contact_manager.repository;

import contact_manager.entity.ContactEntity;
import contact_manager.entity.ProfileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactRepository extends CrudRepository<ContactEntity, UUID> {
        @Query("from ContactEntity where (" +
                "lower(name) like lower(concat('%',:st,'%')) " +
                "or lower(surname) like lower(concat('%',:st,'%')) " +
                "or phone like concat('%',:st,'%')" +
                ") and profile=:profile")
        List<ContactEntity> search(@Param("st") String st, @Param("profile") ProfileEntity profile);
        List<ContactEntity> findByProfile(ProfileEntity profile);
        Optional<ContactEntity> findByIdAndProfile(UUID id, ProfileEntity profile);

        @Transactional
        void deleteByProfile(ProfileEntity profile);
}