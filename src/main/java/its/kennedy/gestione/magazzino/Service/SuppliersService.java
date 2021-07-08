package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Supplier;
import its.kennedy.gestione.magazzino.Dto.SupplierDto;
import its.kennedy.gestione.magazzino.Dto.SupplierInsertDto;
import its.kennedy.gestione.magazzino.Dto.SupplierUpdateDto;
import its.kennedy.gestione.magazzino.IService.ISuppliers;
import its.kennedy.gestione.magazzino.Repository.PurchasesRepository;
import its.kennedy.gestione.magazzino.Repository.SuppliersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliersService implements ISuppliers {

    @Autowired
    SuppliersRepository suppliersRepository;

    @Autowired
    PurchasesRepository purchasesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplierDto getById(Integer id) {
        return modelMapper.map(suppliersRepository.getById(id), SupplierDto.class);
    }

    public Supplier insert(SupplierInsertDto entity) {
        final Supplier supplier = modelMapper.map(entity, Supplier.class);
        supplier.setCreatedAt(Instant.now());
        suppliersRepository.save(supplier);
        return supplier;
    }

    @Override
    public Boolean modifica(SupplierUpdateDto entity) {
        try {
            if (entity.getId() == null) {
                return false;
            } else {
                final Supplier supplier = suppliersRepository.getById(entity.getId());
                supplier.setEmail(entity.getEmail());
                supplier.setIndirizzo(entity.getIndirizzo());
                supplier.setName(entity.getName());
                supplier.setNazione(entity.getNazione());
                supplier.setNote(entity.getNote());
                supplier.setTelefono(entity.getTelefono());
                supplier.setUpdatedAt(Instant.now());
                suppliersRepository.saveAndFlush(supplier);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean elimina(int id) {
        if (purchasesRepository.existsPurchaseBySupplierId(id)) {
            return false;
        }
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
    public List<SupplierDto> getAll(String sortBy, Boolean order) {
        List<SupplierDto> ritorno = new ArrayList<SupplierDto>();
        Direction direction = order == true ? Sort.Direction.ASC : Sort.Direction.DESC;
        List<Supplier> iterable = suppliersRepository.findByDeletedAt(Sort.by(direction, sortBy));
        for (Supplier i : iterable) {
            ritorno.add(modelMapper.map(i, SupplierDto.class));
        }
        return ritorno;
    }
}
