package narval.blog.business.abstracts;

import narval.blog.core.utilities.results.DataResult;
import narval.blog.dataAccess.abstracts.BlogDao;
import narval.blog.entities.concretes.Blog;
import narval.blog.entities.concretes.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BlogServiceTest {

    @Autowired
    BlogService blogService;

    @Autowired
    BlogDao blogDao;

    @Test
    void getAll() {
        Comment comment1 = new Comment(1,"test content","01-01-2001",1, 'A', null);
        List<Comment> commentList = new ArrayList<Comment>();
        List<Blog> blogList = new ArrayList<Blog>();
        commentList.add(comment1);
        Blog blog = new Blog(1,"test title","testsource.png","test body",1,"01-01-2001",0,commentList);
        comment1.setBlog(blog);
        blogList.add(blog);

        Blog blogMock = mock(Blog.class);

        when(blogMock.getId()).thenReturn(1);
        when(this.blogService.getAll()).thenReturn((DataResult<List<Blog>>) blogList);

    }

    @Test
    void getAllSorted() {
    }

    @Test
    void testGetAll() {
    }

    @Test
    void add() {
    }

    @Test
    void getById() {
    }
}