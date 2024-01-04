package hackerthon.liquor.service;

import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.repository.LiquorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LiquorServiceImpl implements LiquorService{

    private final LiquorRepository liquorRepository;
    @Override
    public List<Liquor> getLiquorList() {
        List<Liquor> liquorList = liquorRepository.findAll();
        return liquorList;
    }
}
