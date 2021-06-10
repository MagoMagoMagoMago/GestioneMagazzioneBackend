package its.kennedy.gestione.magazzino.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.kennedy.gestione.magazzino.Dao.ItemsDao;

public interface CategoriesRepository extends JpaRepository<ItemsDao,Integer>{

}
