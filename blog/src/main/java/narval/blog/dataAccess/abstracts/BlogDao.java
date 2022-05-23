package narval.blog.dataAccess.abstracts;

import narval.blog.entities.concretes.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog,Integer> {
    Blog getById(int id);
}
