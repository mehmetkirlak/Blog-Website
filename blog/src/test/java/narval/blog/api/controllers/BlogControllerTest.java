package narval.blog.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import narval.blog.business.abstracts.BlogService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.dataAccess.abstracts.BlogDao;
import narval.blog.entities.concretes.Blog;
import narval.blog.entities.concretes.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BlogController.class)
class BlogControllerTest {

    private final static String CONTENT_TYPE = "application/json";


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BlogService blogService;

    @MockBean
    private BlogDao blogDao;

    @MockBean
    private BlogController blogController;

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

        when(blogDao.findAll()).thenReturn(Collections.singletonList(blog));
        List<Blog> blogs = (List<Blog>) blogService.getAll();

        assertEquals(blogList.size(), 1);
    }

    @Test
    void add() {
        Comment comment1 = new Comment(1,"test content","01-01-2001",1, 'A', null);
        List<Comment> commentList = new ArrayList<Comment>();
        List<Blog> blogList = new ArrayList<Blog>();
        commentList.add(comment1);
        Blog blog = new Blog(1,"test title","testsource.png","test body",1,"01-01-2001",0,commentList);
        comment1.setBlog(blog);
        blogList.add(blog);
        Blog blogMock = mock(Blog.class);

        when(blogDao.save(ArgumentMatchers.any(Blog.class))).thenReturn(blogMock);
    }

    @Test
    void getById() {
        Comment comment1 = new Comment(1,"test content","01-01-2001",1, 'A', null);
        List<Comment> commentList = new ArrayList<Comment>();
        List<Blog> blogList = new ArrayList<Blog>();
        commentList.add(comment1);
        Blog blog = new Blog(1,"test title","testsource.png","test body",1,"01-01-2001",0,commentList);
        comment1.setBlog(blog);
        blogList.add(blog);
        Blog blogMock = mock(Blog.class);



        assertEquals(blogMock.getId(),1);

        when(blogDao.getById(1)).thenReturn((blog));
    }

    @Test
    void getAllSorted() {
    }

    @Test
    void testGetAll() {
    }
}