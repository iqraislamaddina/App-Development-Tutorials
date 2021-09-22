package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.service.TourGuideService;
import apap.tutorial.pergipergi.service.TravelAgensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.*;

@Controller
public class TourGuideController {
    @Qualifier("tourGuideServiceImpl")
    @Autowired
    private TourGuideService tourGuideService;

    @Qualifier("travelAgensiServiceImpl")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @GetMapping("/tour-guide/add/{noAgensi}")
    public String addTourGuideFormPage(@PathVariable Long noAgensi, Model model) {
        TourGuideModel guide = new TourGuideModel();
        TravelAgensiModel agensi = travelAgensiService.getAgensiBynoAgensi(noAgensi);
        guide.setAgensi(agensi);
        model.addAttribute("guide", guide);
        return "form-add-tour-guide";
    }

    @PostMapping("/tour-guide/add")
    public String addTourGuideSubmitPage(@ModelAttribute TourGuideModel tourGuide, Model model) {
        tourGuideService.addTourGuide(tourGuide);
        model.addAttribute("noTourGuide", tourGuide.getNoTourGuide());
        return "add-tour-guide";
    }

    @GetMapping("/tour-guide/update/{noTourGuide}")
    public String updateTourGuidePage(
        @PathVariable Long noTourGuide,
        Model model
        ){
            TourGuideModel tourguide = tourGuideService.getTourGuideBynoTourGuide(noTourGuide);
            model.addAttribute("tour_guide", tourguide);
            // create an LocalDateTime object
            LocalTime DateNow = LocalTime.now();
            // print result
            System.out.println("LocalDateTime : "+ DateNow);
            boolean sebelumbuka = DateNow.isBefore(tourguide.getAgensi().getWaktuBuka());
            boolean setelahtutup = DateNow.isAfter(tourguide.getAgensi().getWaktuTutup());
            boolean bukatutup = tourguide.getAgensi().getWaktuBuka().isBefore(tourguide.getAgensi().getWaktuTutup());
            if ((bukatutup && (sebelumbuka || setelahtutup)) || (!bukatutup && sebelumbuka && setelahtutup)){
                return "form-update-tour-guide";
            } else {
                model.addAttribute("error_message", "Tidak bisa update sebelum tutup!");
                return "error";
            }
            
        }

        @GetMapping("/tour-guide/delete/{noTourGuide}")
        public String deleteTourGuidePage(
            @PathVariable Long noTourGuide,
            Model model
        ){
            TourGuideModel tourguide = tourGuideService.getTourGuideBynoTourGuide(noTourGuide);
            String nama = tourguide.getNamaTourGuide();
            LocalTime DateNow = LocalTime.now();
            // print result
            System.out.println("LocalDateTime : "+ DateNow);
            boolean sebelumbuka = DateNow.isBefore(tourguide.getAgensi().getWaktuBuka());
            boolean setelahtutup = DateNow.isAfter(tourguide.getAgensi().getWaktuTutup());
            boolean bukatutup = tourguide.getAgensi().getWaktuBuka().isBefore(tourguide.getAgensi().getWaktuTutup());
            if ((bukatutup && (sebelumbuka || setelahtutup)) || (!bukatutup && sebelumbuka && setelahtutup)){
                tourGuideService.deleteTourGuideByNoTourGuide(noTourGuide);
                model.addAttribute("victory_message", "Tour Guide " + nama +" berhasil dihapus!");
                return "home";
            } else {
                model.addAttribute("error_message", "Tidak bisa di hapus sebelum tutup!");
                return "error";
            }
            
        }
    
    @PostMapping("/tour-guide/update")
    public String updateTourGuideSubmitPage(
        @ModelAttribute TourGuideModel tourguide,
        Model model
    ){
        
        TourGuideModel updatedTourGuide = tourGuideService.updateTourGuide(tourguide);
        model.addAttribute("noTourGuide", updatedTourGuide.getNoTourGuide());
        model.addAttribute("noAgensi", updatedTourGuide.getAgensi().getNoAgensi());
        return "update-tour-guide";
    }
}