package spring.app.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public BlogModel getById(Integer id) {
        return  blogs.stream()
                    .filter(blog -> blog.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    public BlogModel update(Integer id, BlogModel updatedBlog) {
        Optional<BlogModel> existingBlog = blogs.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst();

        if (existingBlog.isPresent()) {
            BlogModel blog = existingBlog.get();
            blog.setTitle(updatedBlog.getTitle());
            blog.setDescription(updatedBlog.getDescription());
            return blog;
        } else {
            return  null;
        }
    }

    public boolean deleteBlog(Integer id) {
        return blogs.removeIf(blog -> blog.getId().equals(id));
    }

}
