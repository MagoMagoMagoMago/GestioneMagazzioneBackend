package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Category;
import its.kennedy.gestione.magazzino.Dto.CategoryDto;
import its.kennedy.gestione.magazzino.IService.ICategories;
import its.kennedy.gestione.magazzino.Repository.CategoriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService implements ICategories {

    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoriesRepository.findAll()) {
            categoryDtoList.add(modelMapper.map(category, CategoryDto.class));
        }
        return categoryDtoList;
    }
}
