package springhafidtech.gunungcondongdotcom.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springhafidtech.gunungcondongdotcom.entities.Comment;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    private CategoryDto category;

    private UserDto user;

    private Set<CommentDto> comments = new HashSet<>();
}
