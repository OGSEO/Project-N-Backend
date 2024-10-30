package nl.gelton.projectnbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImage extends BaseEntity{


    /* Het opgeslagen bestand staat niet in deze klasse opgeslagen.
       Deze klasse heeft enkel een verwijzing naar de naam van het bestand.
       We weten waar het bestand staat opgeslagen,
       dus met de naam kunnen we naar het bestand verwijzen als "./uploads/{fileName}"
    */
    private String fileName;

//    public String getFileName() {
//        return fileName;
//    }

}
