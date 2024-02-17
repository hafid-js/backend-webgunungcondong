package springhafidtech.gunungcondongdotcom.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class GalleryCategoryDto {

    private Integer galleryCategoryId;

    private String name;

    private String description;
}
