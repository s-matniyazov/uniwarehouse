package org.uniteam.uniwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.domain.entity.Unit;
import org.uniteam.uniwarehouse.repository.UnitRepository;
import org.uniteam.uniwarehouse.service.base.BaseService;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 27 нояб. 2024
 **/
@Service
public class UnitService extends BaseService {
    private final UnitRepository repository;

    @Autowired
    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    public List<Unit> get() {
        return repository.findAll();
    }

    public Unit save(Unit data) {
        return repository.save(data);
    }
}
