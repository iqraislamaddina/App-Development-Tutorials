package apap.tutorial.pergipergi.service;

import java.util.List;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.rest.AgensiDetail;
import reactor.core.publisher.Mono;

public interface TravelAgensiRestService {
    TravelAgensiModel createAgensi(TravelAgensiModel agensi);
    List<TravelAgensiModel> retrieveListAgensi();
    TravelAgensiModel getAgensiByNoAgensi(Long noAgensi);
    TravelAgensiModel updateAgensi(Long noAgensi, TravelAgensiModel agensiUpdate);
    void deleteAgensi(Long noAgensi);
    Mono<String> getStatus(Long noAgensi);
    Mono<AgensiDetail> postStatus();
}