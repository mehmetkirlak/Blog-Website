package narval.blog.api.controllers;

import narval.blog.business.abstracts.CommentService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.SuccessDataResult;
import narval.blog.entities.concretes.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getbyblogid")
    public DataResult<Blog> getById(@RequestParam int id){
        this.commentService.getByBlogId(id);
        return new SuccessDataResult<>("Data getirildi");
    }

}
