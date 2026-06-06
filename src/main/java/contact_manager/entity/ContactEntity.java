package contact_manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone",nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}