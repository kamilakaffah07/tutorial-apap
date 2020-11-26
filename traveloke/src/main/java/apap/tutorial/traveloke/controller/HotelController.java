package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;*/

import java.util.List;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    /**@GetMapping("/")
    private String home(Model model){
        int navFlag = 0;
        model.addAttribute("navFlag", navFlag);
        return "home";
    }*/

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model
    ){

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if (hotel == null){
            int flag = 0; // 0 menandakan update
            model.addAttribute("idHotel", idHotel);
            model.addAttribute("flag", flag);
            return "page-error";
        } else {
            model.addAttribute("hotel", hotel);
            int navFlag = 2;
            model.addAttribute("navFlag", navFlag);
            return "form-update-hotel";
        }
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(

            @ModelAttribute HotelModel hotel,
            Model model
    ){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";

    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model
    ){
        if (idHotel == null){
            int flag = 3;
            model.addAttribute("flag", flag);
            return "page-error";
        }

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);

        if (hotel == null){
            int flag = 1; //1 menandakan view
            model.addAttribute("idHotel",idHotel);
            model.addAttribute("flag", flag);
            return "page-error";
        } else {
            model.addAttribute("hotel", hotel);
            model.addAttribute("listKamar", listKamar);
            boolean hasKamar = listKamar.size() > 0;
            model.addAttribute("hasKamar", hasKamar);
            int navFlag = 1;
            model.addAttribute("navFlag", navFlag);
            return "view-hotel";
        }
    }

    @GetMapping(value = "/hotel/view/{idHotel}")
    public String viewHotelWithPathVariable(
            @PathVariable(value = "idHotel") Long idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        model.addAttribute("listKamar", listKamar);
        boolean hasKamar = listKamar.size() > 0;
        model.addAttribute("hasKamar", hasKamar);
        int navFlag = 1;
        model.addAttribute("navFlag", navFlag);
        return "view-hotel";
    }

    @RequestMapping("/hotel/view-all")
    public String listHotel(Model model){

        // Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        // Add variabel semua HotelModel ke 'listHotel' untuk dirender pada thymleaf
        model.addAttribute("listHotel", listHotel);

        // Return view template yang diinginkan
        return "viewall-hotel";
    }

    @GetMapping(value = "hotel/delete/id-hotel")
    public String deleteHotelKosong(Model model){
            int flag = 5;
            model.addAttribute("flag",flag);
            return "page-error";
    }

    @GetMapping(value = "hotel/delete/id-hotel/{idHotel}")
    public String deleteHotel(
            @PathVariable(value = "idHotel") Long idHotel,
            Model model
    ){
        // Add variabel id hotel ke 'idHotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel", idHotel);
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        if (hotel == null){
            model.addAttribute("idHotel",idHotel);
            int flag = 2;
            model.addAttribute("flag", flag);
            return "page-error";
        } else {
            int jumlahKamar = hotel.getListKamar().size();
            if (jumlahKamar > 0){
                return "not-delete-hotel";
            } else {
                hotelService.deleteHotel(idHotel);
                return "delete-hotel";
            }
        }
    }

}

