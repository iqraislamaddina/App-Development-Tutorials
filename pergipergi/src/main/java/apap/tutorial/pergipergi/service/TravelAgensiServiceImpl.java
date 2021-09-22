package apap.tutorial.pergipergi.service;
 
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.repository.TravelAgensiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
 
@Service
@Transactional
public class TravelAgensiServiceImpl implements TravelAgensiService {
 
    @Autowired
    TravelAgensiDb travelAgensiDb;
 
    @Override
    public void addAgensi(TravelAgensiModel travelAgensi) {
        travelAgensiDb.save(travelAgensi);
    }
 
    @Override
    public List<TravelAgensiModel> getListAgensi() {
        return travelAgensiDb.findByOrderByNamaAgensiAsc();
    }
 
    @Override
    public TravelAgensiModel getAgensiBynoAgensi(Long noAgensi) {
        Optional<TravelAgensiModel> agensi = travelAgensiDb.findByNoAgensi(noAgensi);
        if (agensi.isPresent())
            return agensi.get();
        else
            return null;
    }
 
    @Override
    public TravelAgensiModel updateAgensi(TravelAgensiModel travelAgensi) {
        travelAgensiDb.save(travelAgensi);
        return travelAgensi;
    }

    @Override
    public void deleteAgensiBynoAgensi(Long noAgensi) {
        Optional<TravelAgensiModel> agensi = travelAgensiDb.findByNoAgensi(noAgensi);
        if (agensi.isPresent()){
            TravelAgensiModel travelAgensiModel = agensi.get();
            travelAgensiDb.delete(travelAgensiModel);
        }
            
    }


}