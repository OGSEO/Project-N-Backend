package nl.gelton.projectnbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "political_parties")
public class PoliticalParty extends BaseEntity{

    @NotBlank(message = "Name is required")
    @Column(unique = true)
    private String name;
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

//    @OneToOne(cascade = CascadeType.REMOVE)
//    @JoinColumn(name="logo")
//    private ProfileImage logo;

//    @JsonManagedReference
//    @ManyToMany(mappedBy = "politicalPartyLikes")
//    private List<Idea> topIdeas = new ArrayList<>();


}
