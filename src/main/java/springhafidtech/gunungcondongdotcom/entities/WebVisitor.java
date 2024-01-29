package springhafidtech.gunungcondongdotcom.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "web_visitors")
@NoArgsConstructor
@Setter
@Getter
public class WebVisitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Date date;

    private String ipAddress;

    private String platform;
}
