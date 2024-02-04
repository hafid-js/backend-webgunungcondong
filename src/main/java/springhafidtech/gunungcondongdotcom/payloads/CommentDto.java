package springhafidtech.gunungcondongdotcom.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class CommentDto {

    private Integer commentId;

    private String name;

    private String email;

    private String comment;

    private Date createdAt;

    private String updatedAt;


}
