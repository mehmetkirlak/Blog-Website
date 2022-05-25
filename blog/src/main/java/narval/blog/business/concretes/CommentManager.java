package narval.blog.business.concretes;

import narval.blog.business.abstracts.CommentService;
import narval.blog.core.utilities.results.DataResult;
import narval.blog.core.utilities.results.SuccessDataResult;
import narval.blog.dataAccess.abstracts.CommentDao;
import narval.blog.entities.concretes.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentManager implements CommentService {

    CommentDao commentDao;

    public CommentManager(CommentDao commentDao) {
        commentDao = commentDao;
    }

    @Override
    public DataResult<List<Comment>> getByBlogId(int id) {
        this.commentDao.getByBlogId(id);
        return new SuccessDataResult<>("Comments getirildi.");
    }
}
