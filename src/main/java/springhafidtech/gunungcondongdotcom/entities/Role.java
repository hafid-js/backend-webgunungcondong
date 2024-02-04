package springhafidtech.gunungcondongdotcom.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
@Data
public class Role {

    @Id
    private Integer id;

    private String name;

//    @ManyToMany(mappedBy = "role")
//    private Collection<User> user;

}
