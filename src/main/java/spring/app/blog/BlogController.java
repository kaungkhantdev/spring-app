package spring.app.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping("/")
    public String blog(Model model) {
        model.addAttribute("blogs", this.blogService.getAllBlogs());
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new BlogModel());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BlogModel blog) {
        blogService.create(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.getById(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute BlogModel blog) {
        blogService.update(id, blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return "redirect:/";
    }
}
