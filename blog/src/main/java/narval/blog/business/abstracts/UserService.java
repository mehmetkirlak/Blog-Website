package narval.blog.business.abstracts;

import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.Result;
import narval.blog.entities.concretes.Blog;
import narval.blog.entities.concretes.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);
    DataResult<User> getByUsername(String username);

}
