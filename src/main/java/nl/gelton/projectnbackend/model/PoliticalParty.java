package nl.gelton.projectnbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "political_parties")
public class PoliticalParty extends BaseEntity{

    @NotBlank(message = "Name is required")
    @Column(unique = true)
    private String name;
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

//    @OneToOne(cascade = CascadeType.REMOVE)
//    @JoinColumn(name="logo")
//    private ProfileImage logo;

//    @JsonManagedReference
//    @ManyToMany(mappedBy = "politicalPartyLikes")
//    private List<Idea> topIdeas = new ArrayList<>();


}
