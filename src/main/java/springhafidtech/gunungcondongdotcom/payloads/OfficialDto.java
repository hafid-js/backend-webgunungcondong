package springhafidtech.gunungcondongdotcom.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OfficialDto {

    private Integer officialId;

    private String name;

    private String position;

    private String regisNumber;

    private String image;
}
