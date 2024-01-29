package springhafidtech.gunungcondongdotcom.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Agendas")
@Setter
@Getter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agendaId;

    private String title;

    private String eventSchedule;

    private String location;

    private String coordinator;

    private String phone;

    private String description;

    private Date createdAt;

    private Date updatedAt;


}
