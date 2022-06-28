package narval.blog.business.concretes;

import narval.blog.business.abstracts.UserService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.SuccessDataResult;
import narval.blog.dataAccess.abstracts.UserDao;
import narval.blog.entities.concretes.Blog;
import narval.blog.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Data listelendi.");    }

    @Override
    public DataResult<User> getById(int id) {
        this.userDao.findById(id);
        return new SuccessDataResult<>("Data getirildi");
    }

    @Override
    public DataResult<User> getByUsername(String username) {
        this.userDao.findByUsername(username);
        return new SuccessDataResult<>("Data getirildi");
    }

}
