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
    public HotelModel getHotelByIdHotel(Long idhotel){
        /**int indexx = 0;
        if (listHotel.get(indexx).getIdHotel().equals(idhotel)){
            return listHotel.get(indexx);
        } else {
            for (HotelModel elemenHotel : listHotel){
                indexx++;
                if (elemenHotel.getIdHotel().equals(idhotel)){
                    return elemenHotel;
                }
            }
        }
        return listHotel.get(indexx-1);*/
        return null;
    }

    @Override
    public HotelModel updateHotel(HotelModel hotel){
        return null;
    }



    /**@Override
    public HotelModel udpateNomorTeleponHotel(String idHotel, String noTeleponBaru){
        int index = 0;
        if (listHotel.get(index).equals(idHotel)){
            listHotel.get(index).setNoTelepon(noTeleponBaru);
            return listHotel.get(index);
        } else {
            for (HotelModel elemenHotel : listHotel){
                index++;
                if (elemenHotel.getIdHotel().equals(idHotel)){
                    listHotel.get(index-1).setNoTelepon(noTeleponBaru);
                    return listHotel.get(index-1);
                }
            }
        }
        listHotel.get(index-1).setNoTelepon(noTeleponBaru);
        return listHotel.get(index-1);
    }

    @Override
    public void deleteHotel(String idHotel){

        for(HotelModel hotel : listHotel){
            if(((hotel.getIdHotel()).equals(idHotel))){
                listHotel.remove(hotel);
                return;
            }
        }
    }*/

}
