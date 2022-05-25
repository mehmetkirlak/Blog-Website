package narval.blog.business.abstracts;

import narval.blog.core.utilities.results.DataResult;
import narval.blog.entities.concretes.Comment;


import java.util.List;

public interface CommentService {
    DataResult<List<Comment>> getByBlogId(int id);
}
