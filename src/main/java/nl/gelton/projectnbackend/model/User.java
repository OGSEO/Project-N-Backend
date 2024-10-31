package nl.gelton.projectnbackend.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import nl.gelton.projectnbackend.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity{

    @NotBlank(message = "Name is required")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "Email is required")
    private String email;


    @NotBlank(message = "Password is required")
    private String password;

    private UserRole role;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "profile_image")
    private ProfileImage profileImage;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user")
    @JoinColumn(name = "political_party_id")
    @Nullable
    private PoliticalParty politicalParty;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Idea> ideas = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();


}


