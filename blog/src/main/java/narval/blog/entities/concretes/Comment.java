package narval.blog.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commentId")
    private int id;;

    @Column(name = "content")
    private String content;

    @Column(name="createdAt")
    private String createdAt;

    @Column(name = "authorId")
    private int authorId;

    @Column(name = "isActive")
    private char isActive;

    @ManyToOne()
    @JoinColumn(name = "blogId")
    @JsonIgnore
    private Blog blog;

}
