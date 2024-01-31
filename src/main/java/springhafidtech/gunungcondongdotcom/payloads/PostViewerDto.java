package springhafidtech.gunungcondongdotcom.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class PostViewerDto {

    private Integer viewerId;

    private Date date;

    private String ipAddress;

    private String platform;

    private PostDto post;
}
