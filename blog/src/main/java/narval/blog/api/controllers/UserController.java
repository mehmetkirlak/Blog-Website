package narval.blog.api.controllers;

import narval.blog.business.abstracts.UserService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.SuccessDataResult;

import narval.blog.entities.concretes.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getbyid")
    @PreAuthorize("permitAll()")
    public DataResult<User> getById(@RequestParam int id){
        this.userService.getById(id);
        return new SuccessDataResult<>("Data getirildi.");
    }

}
