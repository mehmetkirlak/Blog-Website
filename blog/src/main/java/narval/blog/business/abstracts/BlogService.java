package narval.blog.business.abstracts;

import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.Result;
import narval.blog.entities.concretes.Blog;

import java.util.List;

public interface BlogService {
    DataResult<List<Blog>> getAll();
    DataResult<List<Blog>> getAllSorted();
    DataResult<List<Blog>> getAll(int pageNo, int pageSize);
    Result add(Blog blog);
    DataResult<Blog> getById(int id);
}
