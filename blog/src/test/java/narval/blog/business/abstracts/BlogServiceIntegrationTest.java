package narval.blog.business.abstracts;

import narval.blog.business.concretes.BlogManager;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.dataAccess.abstracts.BlogDao;
import narval.blog.entities.concretes.Blog;
import narval.blog.entities.concretes.Comment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class BlogServiceIntegrationTest {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogDao blogDao;

    @Test
    void getAll() {
        Comment comment1 = new Comment(1,"test content","01-01-2001",1, 'A', null);
        List<Comment> commentList = new ArrayList<Comment>();
        List<Blog> blogList = new ArrayList<Blog>();
        commentList.add(comment1);
        Blog blog = new Blog(1,"test title","testsource.png","test body",1,"01-01-2001",0,commentList);
        comment1.setBlog(blog);
        blogList.add(blog);

        DataResult<List<Blog>> result = this.blogService.getAll();

        assertFalse( result.getData().isEmpty());
    }
}
