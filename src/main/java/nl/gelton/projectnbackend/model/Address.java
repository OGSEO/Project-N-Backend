package nl.gelton.projectnbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{

    private String street;
    private String zipCode;
    private String city;
    private String country;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;
}
