package apap.tutorial.pergipergi.service;

import java.util.List;
import apap.tutorial.pergipergi.model.DestinasiModel;
import reactor.core.publisher.Mono;

public interface DestinasiRestService {
    DestinasiModel createDestinasi(DestinasiModel Destinasi);
    List<DestinasiModel> retrieveListDestinasi();
    DestinasiModel getDestinasiByNoDestinasi(Long noDestinasi);
    DestinasiModel updateDestinasi(Long noDestinasi, DestinasiModel DestinasiUpdate);
    void deleteDestinasi(Long noDestinasi);
    
}