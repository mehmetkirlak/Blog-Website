package narval.blog.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="postId")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="imageSource")
    private String imageSource;

    @Column(name="body")
    private String body;

    @Column(name = "authorId")
    private int authorId;

    @Column(name="createdAt")
    private String createdAt;

    @Column(name="isPublished")
    private int isPublished;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;

}
