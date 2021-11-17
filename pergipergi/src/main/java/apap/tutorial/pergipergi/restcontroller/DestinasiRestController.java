package apap.tutorial.pergipergi.restcontroller;
 
import apap.tutorial.pergipergi.model.DestinasiModel;
import apap.tutorial.pergipergi.service.DestinasiRestService;
import reactor.core.publisher.Mono;
import apap.tutorial.pergipergi.rest.AgensiDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class DestinasiRestController {
    @Autowired
    private DestinasiRestService destinasiRestService;

    @PostMapping(value = "/destinasi")
    private ResponseEntity<String> createDestinasi(@Valid @RequestBody DestinasiModel destinasi,
    BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        } else {
            destinasiRestService.createDestinasi(destinasi);
            return ResponseEntity.ok("Create Destinasi success");
        }
    }

    @GetMapping(value = "/destinasi/{noDestinasi}")
    private DestinasiModel retrieveDestinasi(@PathVariable("noDestinasi") Long noDestinasi) {
        try {
            return destinasiRestService.getDestinasiByNoDestinasi(noDestinasi);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No Destinasi " + String.valueOf(noDestinasi) + " Not Found."
            );
        }
    }

    @DeleteMapping(value = "/destinasi/{noDestinasi}")
    private ResponseEntity deleteDestinasi(@PathVariable("noDestinasi") Long noDestinasi){
        try {
            destinasiRestService.deleteDestinasi(noDestinasi);
            return ResponseEntity.ok("Destinasi has been deleted!");
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Destinasi with No Destinasi " + String.valueOf(noDestinasi) + " Not Found."
            );
            
        }
    }

    @PutMapping(value = "/destinasi/{noDestinasi}")
    private ResponseEntity<String> updateDestinasi(@PathVariable("noDestinasi") long noDestinasi, @RequestBody DestinasiModel destinasi){
        try{
            destinasiRestService.updateDestinasi(noDestinasi, destinasi);
            return ResponseEntity.ok("Update destinasi success");
        }

        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Destinasi with No Destinasi " + String.valueOf(noDestinasi) + " Not Found."
            );
        }
    }

    @GetMapping(value = "/list-destinasi")
    private List<DestinasiModel> retrieveListDestinasi(){ 
        return destinasiRestService.retrieveListDestinasi();
    }
}