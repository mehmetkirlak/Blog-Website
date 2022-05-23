package narval.blog.business.concretes;

import narval.blog.business.abstracts.BlogService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.Result;
import narval.blog.core.utilities.results.SuccesResult;
import narval.blog.core.utilities.results.SuccessDataResult;
import narval.blog.dataAccess.abstracts.BlogDao;
import narval.blog.entities.concretes.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogManager implements BlogService {

    private BlogDao blogDao;

    @Autowired
    public BlogManager(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public DataResult<List<Blog>> getAll() {
        return new SuccessDataResult<List<Blog>>(this.blogDao.findAll(),"Data listelendi.");
    }

    @Override
    public Result add(Blog blog) {
        this.blogDao.save(blog);
        return new SuccesResult("Blog eklendi");
    }

    @Override
    public DataResult<Blog> getById(int id) {
        this.blogDao.getById(id);
        return new SuccessDataResult<>("Data getirildi");
    }


}
