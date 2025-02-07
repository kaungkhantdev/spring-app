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

    @GetMapping("/{id}")
    public BlogModel getById(@PathVariable Integer id) {
        return this.blogService.getById(id);
    }

    @PutMapping("/{id}")
    public BlogModel update(@PathVariable Integer id, @RequestBody BlogModel blog) {
        return this.blogService.update(id, blog);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = this.blogService.deleteBlog(id);
        return isDeleted ? "Blog is deleted successfully." : "Not found";
    }
}
