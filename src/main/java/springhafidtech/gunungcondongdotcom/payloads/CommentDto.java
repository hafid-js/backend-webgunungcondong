package springhafidtech.gunungcondongdotcom.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;


}
