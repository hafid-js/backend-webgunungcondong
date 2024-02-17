package springhafidtech.gunungcondongdotcom.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springhafidtech.gunungcondongdotcom.entities.GalleryCategory;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class GalleryDto {

    private Integer galleryId;

    private String image;

    private GalleryCategory galleryCategory;

    private Date createdAt;
}
