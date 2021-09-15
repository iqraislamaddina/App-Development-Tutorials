package apap.tutorial.pergipergi.service;
 
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import java.util.*;
import org.springframework.stereotype.Service;
 
@Service
public class TravelAgensiServiceImpl implements TravelAgensiService {
    
    private List<TravelAgensiModel> listAgensi;
 
    public TravelAgensiServiceImpl(){
        listAgensi = new ArrayList ();
    }
 
    @Override
    public void addAgensi(TravelAgensiModel travelAgensiModel){
        listAgensi.add(travelAgensiModel);
    }

    @Override
    public void deleteAgensi(TravelAgensiModel travelAgensiModel){
        if (travelAgensiModel != null){
            listAgensi.remove(travelAgensiModel);
        }
        return;
    }
 
    @Override
    public List<TravelAgensiModel> getListAgensi(){
        return listAgensi;
    }
 
    @Override
    public TravelAgensiModel getAgensiByidAgensi(String idAgensi) {
        for (TravelAgensiModel i : listAgensi) {
            if (i.getIdAgensi().equals(idAgensi)){
                return i;
            }
        }
        return null;
    }
}
