package narval.blog.api.controllers;

import narval.blog.business.abstracts.BlogService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.Result;
import narval.blog.entities.concretes.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/getall")
    public DataResult<List<Blog>> getAll() {
        return this.blogService.getAll();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    public Result add(@RequestBody Blog blog){
    return this.blogService.add(blog);
    }

    @GetMapping("/getbyid")
    @PreAuthorize("permitAll()")
    public DataResult<Blog> getById(@RequestParam int id){
        return this.blogService.getById(id);
    }

    @GetMapping("/getallsorted")
    public DataResult<List<Blog>> getAllSorted(){return this.blogService.getAllSorted();}

    @GetMapping("/getAllByPage")
    DataResult<List<Blog>> getAll(int pageNo, int pageSize){
        return this.blogService.getAll(pageNo, pageSize);
    }

}
