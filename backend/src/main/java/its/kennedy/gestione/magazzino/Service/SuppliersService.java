package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Supplier;
import its.kennedy.gestione.magazzino.Dto.SupplierDto;
import its.kennedy.gestione.magazzino.IService.ISuppliers;
import its.kennedy.gestione.magazzino.Repository.SuppliersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliersService implements ISuppliers {
    @Autowired
    SuppliersRepository suppliersRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplierDto getById(Integer id) {
        return modelMapper.map(suppliersRepository.getById(id), SupplierDto.class);
    }

    @Override
    public Boolean modifica(Supplier entity) {
        try {
            if (entity.getId() == null) {
                entity.setCreatedAt(Instant.now());
            } else {
                entity.setUpdatedAt(Instant.now());
            }
            suppliersRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override
    public Boolean elimina(int id) {
        try {
        	Supplier entity = suppliersRepository.findById(id).get();
            entity.setDeletedAt(Instant.now());
            suppliersRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override
    public List<SupplierDto> getAll(String ord) {
        List<SupplierDto> ritorno = new ArrayList<SupplierDto>();
        List<Supplier> iterable = suppliersRepository.findByDeletedAt(Sort.by(Sort.Direction.ASC,ord));
        for (Supplier i : iterable) {
            ritorno.add(modelMapper.map(i, SupplierDto.class));
        }
        return ritorno;
    }
}
