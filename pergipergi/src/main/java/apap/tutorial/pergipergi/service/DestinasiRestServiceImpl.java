package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.DestinasiModel;
import apap.tutorial.pergipergi.repository.DestinasiDb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import apap.tutorial.pergipergi.rest.Setting;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;


import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;



    @Service
    @Transactional
    public class DestinasiRestServiceImpl implements DestinasiRestService {

        @Autowired
        private DestinasiDb destinasiDb;

        // private final WebClient webClient;

        @Override
        public DestinasiModel createDestinasi(DestinasiModel destinasi) {
            return destinasiDb.save(destinasi);
        }

        @Override
        public List<DestinasiModel> retrieveListDestinasi(){
            return destinasiDb.findAll();
        }

        @Override
        public DestinasiModel getDestinasiByNoDestinasi(Long noDestinasi) {
            Optional<DestinasiModel> destinasi = destinasiDb.findByNoDestinasi(noDestinasi);

            if(destinasi.isPresent()){
                return destinasi.get();
            } else {
                throw new NoSuchElementException();
            }
        }

    @Override
    public DestinasiModel updateDestinasi(Long noDestinasi, DestinasiModel DestinasiUpdate){
        DestinasiModel Destinasi = getDestinasiByNoDestinasi(noDestinasi);
        Destinasi.setNegaraDestinasi(DestinasiUpdate.getNegaraDestinasi());
        Destinasi.setIsBebasVisa(DestinasiUpdate.getIsBebasVisa());
        

        return destinasiDb.save(Destinasi);
    }

    @Override
    public void deleteDestinasi(Long noDestinasi){
        DestinasiModel Destinasi = getDestinasiByNoDestinasi(noDestinasi);
        destinasiDb.delete(Destinasi);
    }

}
