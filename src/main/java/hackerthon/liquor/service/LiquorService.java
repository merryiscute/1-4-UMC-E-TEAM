package hackerthon.liquor.service;

import hackerthon.liquor.domain.Liquor;

import java.util.List;
import java.util.Optional;

public interface LiquorService {
    List<Liquor> getLiquorList();
}
