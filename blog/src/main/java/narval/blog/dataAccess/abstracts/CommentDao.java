package narval.blog.dataAccess.abstracts;


import narval.blog.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment , Integer> {
    List<Comment> getByBlogId(int id);
}
