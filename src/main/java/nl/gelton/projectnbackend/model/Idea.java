package nl.gelton.projectnbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ideas")
public class Idea extends BaseEntity {

    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;

//    @JsonIgnore
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


//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "ideas_users",
//            joinColumns = @JoinColumn(name = "idea_liked"),
//            inverseJoinColumns = @JoinColumn(name = "user_liked")
//    )
//    private Set<User> userLikes = new HashSet<>();

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_owner")
    private User user;

}
