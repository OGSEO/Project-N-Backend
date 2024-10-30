package nl.gelton.projectnbackend.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.Fetch;

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


//    @ManyToMany
//    @JoinTable(
//            name = "ideas_political_partys",
//            joinColumns = {
//                    @JoinColumn(name = "idea")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "party")
//            })
//    private List<PoliticalParty> politicalPartyLikes = new ArrayList<>();


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

}
