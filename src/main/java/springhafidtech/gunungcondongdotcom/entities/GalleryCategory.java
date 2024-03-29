package springhafidtech.gunungcondongdotcom.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gallery_categories")
@NoArgsConstructor
@Setter
@Getter
public class GalleryCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer galleryCategoryId;

    private String name;

    private String description;
}
