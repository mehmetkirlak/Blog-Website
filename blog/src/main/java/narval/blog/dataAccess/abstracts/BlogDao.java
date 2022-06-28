package narval.blog.dataAccess.abstracts;

import narval.blog.entities.concretes.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao extends JpaRepository<Blog,Integer> {

    @Override
    List<Blog> findAll();

}
