package spring.app.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    private final List<BlogModel> blogs = new ArrayList<>();
    private Integer currentId = 1;

    public BlogModel create(BlogModel blog) {
        blog.setId(currentId++);
        blogs.add(blog);
        return blog;
    }

    public List<BlogModel> getAllBlogs() {
        return blogs;
    }
}
