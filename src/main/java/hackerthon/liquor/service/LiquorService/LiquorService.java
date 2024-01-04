package hackerthon.liquor.service.LiquorService;

import hackerthon.liquor.domain.Liquor;

import java.util.List;

public interface LiquorService {


    public List<Liquor> findAll();

    public List<Liquor> findByCategoryId(Long categoryId);
}
