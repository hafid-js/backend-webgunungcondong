package springhafidtech.gunungcondongdotcom.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class AgendaDto {

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
