package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelInMemoryService implements HotelService {

    private List<HotelModel> listHotel;

    //Constructor
    public HotelInMemoryService(){
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel){
        listHotel.add(hotel);
    }

    @Override
    public List<HotelModel> getHotelList(){
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idhotel){
        int indexHotel = 0;
        for (int i = 0; i<listHotel.size(); i++){
            if (listHotel.get(i).getIdHotel() == idhotel){
                indexHotel = i;
            }
        }
        return listHotel.get(indexHotel);
    }

    @Override
    public HotelModel udpateNomorTeleponHotel(String idHotel, String noTeleponBaru){
        int indexHotel = 0;
        for (int i = 0; i<listHotel.size(); i++){
            if (listHotel.get(i).getIdHotel() == idHotel){
                indexHotel = i;
            }
        }
        listHotel.get(indexHotel).setNoTelepon(noTeleponBaru);
        return listHotel.get(indexHotel);
    }

    @Override
    public void deleteHotel(String idHotel){
        int indexHotel = 0;
        for (int i = 0; i<listHotel.size(); i++){
            if (listHotel.get(i).getIdHotel() == idHotel){
                indexHotel = i;
            }
        }
        listHotel.remove(indexHotel);
    }

}
