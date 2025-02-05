package spring.app.blog;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class ApiBlogController {
    private final BlogService blogService;

    public ApiBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<BlogModel> getAllBlogs() {
        return this.blogService.getAllBlogs();
    }

    @PostMapping
    public BlogModel crate(@RequestBody BlogModel blog) {
        return this.blogService.create(blog);
    }
}
