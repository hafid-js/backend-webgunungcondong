package springhafidtech.gunungcondongdotcom.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "village_officials")
@NoArgsConstructor
@Setter
@Getter
public class VillageOfficial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer officialId;

    private String name;

    private String position;

    private String regisNumber;

    private String image;


}
