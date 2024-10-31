package nl.gelton.projectnbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ideas")
public class Idea extends BaseEntity {

    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;

//    @OneToMany(mappedBy = "idea", cascade = CascadeType.REMOVE)
//    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_owner")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ideas_users",
            joinColumns = @JoinColumn(name = "idea_liked"),
            inverseJoinColumns = @JoinColumn(name = "user_liked")
    )
    private Set<User> userLikes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "ideas_political_partys",
            joinColumns = @JoinColumn(name = "idea_supported"),
            inverseJoinColumns = @JoinColumn(name = "party_support")
    )
    private Set<PoliticalParty> politicalSupports = new HashSet<>();

}
