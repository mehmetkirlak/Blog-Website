package narval.blog.api.controllers;

import narval.blog.business.abstracts.BlogService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.Result;
import narval.blog.entities.concretes.Blog;
import narval.blog.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping()
    public DataResult<List<Blog>> getAll() throws ApiRequestException {
        DataResult<List<Blog>> result = this.blogService.getAll();
        if (result.getData().isEmpty()) {
            throw new ApiRequestException("Data getirilemedi.");
        }
            return this.blogService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Blog blog){
        if (blog.getBody().isEmpty() || blog.getBody().isEmpty()) {
            throw new ApiRequestException("Data kayıt edilmedi.");
        }
    return this.blogService.add(blog);
    }

    @GetMapping("/getbyid")
    public DataResult<Blog> getById(@RequestParam int id){
        return this.blogService.getById(id);
    }

    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable int id) {
        return blogService.getById(id).getData();
    }

    @GetMapping("/getallsorted")
    public DataResult<List<Blog>> getAllSorted(){
        DataResult<List<Blog>> result = this.blogService.getAllSorted();
        if (result.getData().isEmpty()) {
            throw new ApiRequestException("Data getirilemedi.");
        }
        return this.blogService.getAllSorted();}

    @GetMapping("/getAllByPage")
    DataResult<List<Blog>> getAll(int pageNo, int pageSize){
        DataResult<List<Blog>> result = this.blogService.getAll(pageNo,pageSize);
        if (result.getData().isEmpty()) {
            throw new ApiRequestException("Data getirilemedi.");
        }
        return this.blogService.getAll(pageNo, pageSize);
    }

}
