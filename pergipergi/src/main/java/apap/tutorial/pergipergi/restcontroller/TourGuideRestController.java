package apap.tutorial.pergipergi.restcontroller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.repository.TourGuideDb;
import apap.tutorial.pergipergi.rest.AgensiDetail;
import apap.tutorial.pergipergi.service.TourGuideRestService;
import apap.tutorial.pergipergi.service.TourGuideService;
import apap.tutorial.pergipergi.service.TravelAgensiRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")

public class TourGuideRestController {

    @Autowired
    private TourGuideRestService tourGuideRestService;

    @Autowired
    private TourGuideService tourGuideService;

    @Autowired
    private TourGuideDb tourGuideDb;

    @GetMapping(value = "/tour/umur/{noTourGuide}")
    private TourGuideModel getAge(@PathVariable("noTourGuide") Long noTourGuide){
        TourGuideModel guide = tourGuideService.getTourGuideBynoTourGuide(noTourGuide);
        String umur = tourGuideRestService.getAge(guide.getNamaTourGuide()).block();

        String value = umur;

        value = value.substring(1, value.length()-1);
        String[] keyValuePairs = value.split(",");
        Map<String,String> map = new HashMap<>();

        for(String pair : keyValuePairs) //iterate over the pairs
        {
            String[] entry = pair.split(":"); //split the pairs to get key and value
            map.put(entry[0].trim().replace("\"", ""), entry[1].trim().replace("\"", "")); //add them to the hashmap and trim whitespaces
        }

        guide.setUmur(Integer.valueOf(map.get("age")));

        return tourGuideDb.save(guide);
    }


}