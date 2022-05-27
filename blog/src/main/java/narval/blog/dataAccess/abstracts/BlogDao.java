package narval.blog.dataAccess.abstracts;

import narval.blog.entities.concretes.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogDao extends JpaRepository<Blog,Integer> {
    Blog getById(int id);

}
