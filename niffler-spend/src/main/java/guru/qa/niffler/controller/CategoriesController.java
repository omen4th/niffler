package guru.qa.niffler.controller;

import guru.qa.niffler.model.CategoryJson;
import guru.qa.niffler.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/internal/categories")
public class CategoriesController {

    private final CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<CategoryJson> getCategories(@RequestParam String username) {
        return categoryService.getAllCategories(username);
    }

    @PostMapping("/add")
    public CategoryJson addCategory(@RequestBody CategoryJson category) {
        return categoryService.addCategory(category);
    }
}
