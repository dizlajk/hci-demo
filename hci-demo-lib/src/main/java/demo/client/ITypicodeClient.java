package demo.client;

import demo.dto.Post;
import demo.dto.User;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

public interface ITypicodeClient {
    User getUser(String Id);

    List<Post> getPostByUserId(String Id);

    @Async
    Future<User> getUserAsync(String id);

    @Async
    Future<List<Post>> getPostByUserIdAsync(String id);
}
