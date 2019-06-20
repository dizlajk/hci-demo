package demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result extends User{
    private List<Post> posts;

    public Result(User user, List<Post> posts) {
        this.setEmail(user.getEmail());
        this.setName(user.getUsername());
        this.setUsername(user.getUsername());
        this.setPosts(posts);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Result{" +
                super.toString() +
                "posts=" + posts +
                '}';
    }
}
