package springhafidtech.gunungcondongdotcom.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    private String thumbnail;

    private String shortDescription;

    private String content;

    private boolean isPublish;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User user;

    private Date createdAt;

    private Date updatedAt;

}
