package springhafidtech.gunungcondongdotcom.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "settings")
@NoArgsConstructor
@Setter
@Getter
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer settingId;

    private String title;

    private String logo;

    private String email;

    private String fullAddress;

    private String phone;

    private String facebook;

    private String youtube;

    private String instagram;

    private String youtubeLinksWidget;
}
