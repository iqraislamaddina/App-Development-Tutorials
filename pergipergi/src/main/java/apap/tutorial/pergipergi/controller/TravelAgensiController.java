package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.model.DestinasiModel;
import apap.tutorial.pergipergi.service.TravelAgensiService;
import apap.tutorial.pergipergi.service.DestinasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TravelAgensiController {

    @Qualifier("travelAgensiServiceImpl")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @Autowired
    private DestinasiService destinasiService;

    @GetMapping("/agensi/add")
    public String addAgensiFormPage(Model model) {
        model.addAttribute("agensi", new TravelAgensiModel());
        List<DestinasiModel> listDestinasiModels = destinasiService.getListDestinasi();
        model.addAttribute("listDestinasi", listDestinasiModels);
        return "form-add-agensi";
    }

    @PostMapping(value = "/agensi/add", params = { "submitAgensi" })
    public String addAgensiSubmitPage(@ModelAttribute TravelAgensiModel agensi, Model model) {
        travelAgensiService.addAgensi(agensi);
        model.addAttribute("noAgensi", agensi.getNoAgensi());
        return "add-agensi";
    }

    @PostMapping(value = "/agensi/add", params = { "addRow" })
    public String addRow(@ModelAttribute TravelAgensiModel agensi, BindingResult bindingResult, Model model) {
        List<DestinasiModel> listDestinasiModels = destinasiService.getListDestinasi();


        if (agensi.getListDestinasi() == null) {
            agensi.setListDestinasi(new ArrayList<DestinasiModel>());
        }
        List<DestinasiModel> listDestinasiBaru = agensi.getListDestinasi();
        listDestinasiBaru.add(new DestinasiModel());

        model.addAttribute("listDestinasi", listDestinasiModels);
        model.addAttribute("agensi", agensi);
        return "form-add-agensi";
    }

    @RequestMapping(value = "/agensi/add", method = RequestMethod.POST, params = { "deleteRow" })
    public String deleteRow(@ModelAttribute TravelAgensiModel agensi, final BindingResult bindingResult,
            final HttpServletRequest req, Model model) {
        List<DestinasiModel> listDestinasiModels = destinasiService.getListDestinasi();

        final Integer rowId = Integer.valueOf(req.getParameter("deleteRow"));
        agensi.getListDestinasi().remove(rowId.intValue());

        model.addAttribute("listDestinasi", listDestinasiModels);
        model.addAttribute("agensi", agensi);
        return "form-add-agensi";
    }


    @GetMapping("/agensi/viewall")
    public String listAgensi(Model model) {
        List<TravelAgensiModel> listAgensi = travelAgensiService.getListAgensi();
        model.addAttribute("listAgensi", listAgensi);
        return "viewall-agensi";
    }

    @GetMapping("/agensi/view")
    public String viewDetailAgensiPage(@RequestParam(value = "noAgensi") Long noAgensi, Model model) {
        TravelAgensiModel agensi = travelAgensiService.getAgensiBynoAgensi(noAgensi);
        List<TourGuideModel> listTourGuide = agensi.getListTourGuide();
        List<DestinasiModel> listDestinasiBaru = agensi.getListDestinasi();

        model.addAttribute("agensi", agensi);
        model.addAttribute("listTourGuide", listTourGuide);
        model.addAttribute("listDestinasiBaru", listDestinasiBaru);
        return "view-agensi";
    }

    @GetMapping("/agensi/update/{noAgensi}")
    public String updateAgensiFormPage(@PathVariable Long noAgensi, Model model) {
        TravelAgensiModel agensi = travelAgensiService.getAgensiBynoAgensi(noAgensi);
        model.addAttribute("agensi", agensi);
        return "form-update-agensi";
    }

    @PostMapping("/agensi/update")
    public String updateAgensiSubmitPage(@ModelAttribute TravelAgensiModel agensi, Model model) {
        TravelAgensiModel updatedAgensi = travelAgensiService.updateAgensi(agensi);
        model.addAttribute("noAgensi", updatedAgensi.getNoAgensi());
        return "update-agensi";
    }

    @GetMapping("/agensi/delete/{noAgensi}")
    public String deleteTravelAgensiPage(@PathVariable Long noAgensi, Model model) {
        TravelAgensiModel agensi = travelAgensiService.getAgensiBynoAgensi(noAgensi);
        List<TourGuideModel> list_tour = agensi.getListTourGuide();
        String nama = agensi.getNamaAgensi();
        LocalTime DateNow = LocalTime.now();
        // print result
        System.out.println("LocalDateTime : " + DateNow);
        boolean sebelumbuka = DateNow.isBefore(agensi.getWaktuBuka());
        boolean setelahtutup = DateNow.isAfter(agensi.getWaktuTutup());
        boolean bukatutup = agensi.getWaktuBuka().isBefore(agensi.getWaktuTutup());
        if (((bukatutup && (sebelumbuka || setelahtutup)) || (!bukatutup && sebelumbuka && setelahtutup))
                && list_tour.isEmpty()) {
            travelAgensiService.deleteAgensiBynoAgensi(noAgensi);
            model.addAttribute("victory_message", "Agensi " + nama + " berhasil dihapus!");
            return "home";
        } else {
            model.addAttribute("error_message", "Tidak bisa di hapus sebelum tutup atau tour guide kosong!");
            return "error";
        }

    }

}