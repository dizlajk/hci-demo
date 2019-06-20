package demo.service;

import demo.client.ITypicodeClient;
import demo.dto.Post;
import demo.dto.Result;
import demo.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class TypicodeService implements ITypicodeService {

    private final ITypicodeClient client;

    public TypicodeService(ITypicodeClient client) {
        this.client = client;
    }

    public Result getResult(String userId) {
        Future<User> userFuture = client.getUserAsync(userId);
        Future<List<Post>> postFuture = client.getPostByUserIdAsync(userId);

        while (true) {
            if (userFuture.isDone() && postFuture.isDone()) {
                try {
                    return new Result(userFuture.get(), postFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
