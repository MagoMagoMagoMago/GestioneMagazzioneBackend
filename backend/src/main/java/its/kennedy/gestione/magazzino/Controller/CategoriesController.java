package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dto.CategoryDto;
import its.kennedy.gestione.magazzino.Service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Transactional
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok().body(categoriesService.getAll());
    }
}
