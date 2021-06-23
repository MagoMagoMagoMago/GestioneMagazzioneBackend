package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.CategoryDto;

import java.util.List;

public interface ICategories {

    /**
     * Gets all the Categories
     *
     * @return a list of CategoryDto
     */
    public List<CategoryDto> getAll();

}
