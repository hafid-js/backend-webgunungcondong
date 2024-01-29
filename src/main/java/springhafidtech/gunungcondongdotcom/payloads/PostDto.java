package springhafidtech.gunungcondongdotcom.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class PostDto {

    private Integer postId;

    private String title;

    private String thumbnail;

    private String shortDescription;

    private String content;

    private boolean isPublish;

    private Date createdAt;

    private Date updatedAt;

    private CategoryDto category;

    private UserDto user;
}
