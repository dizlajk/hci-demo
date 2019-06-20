package demo.client;

import demo.dto.Post;
import demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

@Component
public class TypicodeClient implements ITypicodeClient {

    private static final Logger log = LoggerFactory.getLogger(TypicodeClient.class);
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";


    private final RestTemplate restTemplate;

    public TypicodeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User getUser(String id) {
        return restTemplate.getForObject(BASE_URL + "users/" + id, User.class);
    }

    @Override
    public List<Post> getPostByUserId(String userId) {
        Post[] posts = restTemplate.getForObject(BASE_URL + "posts?userId=" + userId, Post[].class);
        return Arrays.asList(Objects.requireNonNull(posts));
    }

    @Override
    @Async
    public Future<User> getUserAsync(String id) {
        return new AsyncResult<>(getUser(id));
    }

    @Override
    @Async
    public Future<List<Post>> getPostByUserIdAsync(String id) {
        return new AsyncResult<>(getPostByUserId(id));
    }
}
