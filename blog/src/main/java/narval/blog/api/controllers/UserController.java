package narval.blog.api.controllers;

import narval.blog.business.abstracts.UserService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.SuccessDataResult;

import narval.blog.entities.concretes.Blog;
import narval.blog.entities.concretes.User;
import narval.blog.exception.ApiRequestException;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public DataResult<List<User>> getAll() throws ApiRequestException {
        DataResult<List<User>> result = this.userService.getAll();
        if (result.getData().isEmpty()) {
            throw new ApiRequestException("Data getirilemedi.");
        }
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public User getBlog(@PathVariable int id) {
        return userService.getById(id).getData();
    }

    @GetMapping("/getbyid")
    public DataResult<User> getById(@RequestParam int id){
        this.userService.getById(id);
        return new SuccessDataResult<>("Data getirildi.");
    }

}
