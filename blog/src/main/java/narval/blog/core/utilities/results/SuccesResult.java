package narval.blog.core.utilities.results;

public class SuccesResult extends Result {

    public SuccesResult(){
        super(true);
    }
    public SuccesResult(String message) {
        super(true,message);
    }
}
