package springhafidtech.gunungcondongdotcom.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "addresses")
@NoArgsConstructor
@Setter
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private String street;

    private String city;

    private String postalCode;

    private String country;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
