package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Purchase;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.PurchaseDto;
import its.kennedy.gestione.magazzino.IService.IPurchases;
import its.kennedy.gestione.magazzino.Repository.PurchasesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;

@Service
public class PurchasesService implements IPurchases {
    @Autowired
    private PurchasesRepository puchasesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PurchaseDto getById(Integer id) {
        Purchase purchase = puchasesRepository.getById(id);
        PurchaseDto purchaseDto = modelMapper.map(purchase, PurchaseDto.class);
        purchaseDto.setSupplier(purchase.getSupplier().getName());
        return purchaseDto;
    }

    @Override
    public Boolean modifica(Purchase entity) {
        try {
            if (entity.getId() == null) {
                entity.setCreatedAt(Instant.now());
            } else {
                entity.setUpdatedAt(Instant.now());
            }
            puchasesRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean elimina(int id) {
        try {
            Purchase entity = puchasesRepository.findById(id).get();
            entity.setDeletedAt(Instant.now());
            puchasesRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public BaseResponsePage<PurchaseDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean order) {
        Pageable p;
        if (sortBy.length() <= 0) {
            sortBy = "Id";
        }
        if (order) {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
        } else {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
        }
        Page<Purchase> resP = puchasesRepository.findAllByDeletedAt(null, p);
        BaseResponsePage<PurchaseDto> baseResponsePage = new BaseResponsePage<PurchaseDto>();
        baseResponsePage.setPagine(resP.getTotalPages());
        ArrayList<PurchaseDto> res = new ArrayList<PurchaseDto>();
        for (Purchase purchase : resP) {
            PurchaseDto purchaseDto = modelMapper.map(purchase, PurchaseDto.class);
            purchaseDto.setSupplier(purchase.getSupplier().getName());
            res.add(purchaseDto);
        }
        baseResponsePage.setList(res);
        return baseResponsePage;
    }
}
