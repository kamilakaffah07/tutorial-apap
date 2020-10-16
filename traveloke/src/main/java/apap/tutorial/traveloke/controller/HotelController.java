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

    @GetMapping("/")
    private String home(){
        return "home";
    }

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
            model.addAttribute("jumlahKamar", listKamar.size());
            return "view-hotel";
        }
    }

    @RequestMapping("/hotel/viewall")
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



    /**
    // Routing URL yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotel(
            // Request parameter yang ingin dibawa
            @RequestParam(value = "idHotel", required = true) String idHotel,
            @RequestParam(value = "namaHotel", required = true) String namaHotel,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ){

        // Membuat objek HotelModel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        // Memanggil service addHotel
        hotelService.addHotel(hotel);

        // Add variabel id hotel ke 'idHotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel", idHotel);

        // Return view template yang digunakan
        return "add-hotel";
    }

    // Request handler untuk method getHotelList
    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){

        // Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        // Add variabel semua HotelModel ke 'listHotel' untuk dirender pada thymleaf
        model.addAttribute("listHotel", listHotel);

        // Return view template yang diinginkan
        return "viewall-hotel";
    }

    // Reqest param untuk method getHotelByIdHotel
    @RequestMapping("hotel/view")
    public String detailHotel(
            @RequestParam(value = "idHotel") String idHotel,
            Model model){

        // Mendapatkan HotelModel sesuaidengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        //Add variabel HotelModel ke 'hotel' untuk dirender pada thymeleaf
        model.addAttribute("hotel", hotel);

        return "view-hotel";
    }

    // Path Variable untuk method getHotelByIdHotel
    @GetMapping(value= "/hotel/view/id-hotel/{idHotel}")
    public String viewHotelWithPathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        // Mendapatkan HotelModel sesuaidengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        //Add variabel HotelModel ke 'hotel' untuk dirender pada thymeleaf
        model.addAttribute("hotel", hotel);

        return "view-hotel";
    }

    // Path Variable untuk method updateNomorTeleponHotel
    @GetMapping(value= "hotel/update/id-hotel/{idHotel}/no-telepon/{noTeleponBaru}")
    public String updateNoTeleponHotel(
            @PathVariable(value = "idHotel") String idHotel,
            @PathVariable(value = "noTeleponBaru") String noTeleponBaru,
            Model model
    ){
        // Mendapatkan HotelModel sesuaidengan idHotel
        HotelModel hotel = hotelService.udpateNomorTeleponHotel(idHotel, noTeleponBaru);

        //Add variabel HotelModel ke 'hotel' untuk dirender pada thymeleaf
        model.addAttribute("hotel", hotel);

        return "view-hotel-update";
    }

    //Path Variable untuk method deleteHotel
    @GetMapping(value = "hotel/delete/id-hotel/{idHotel}")
    public String deleteHotel(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        // Add variabel id hotel ke 'idHotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel", idHotel);
        hotelService.deleteHotel(idHotel);
        // Return view template yang digunakan
        return "delete-hotel";
    }*/

}

