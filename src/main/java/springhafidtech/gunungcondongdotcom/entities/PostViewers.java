package springhafidtech.gunungcondongdotcom.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;


@Entity
@Table(name = "post_viewers")
@NoArgsConstructor
@Setter
@Getter
public class PostViewers{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer viewerId;

    private Date date;

    private String ipAddress;

    private String platform;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "post_id")
    private Post post;
}