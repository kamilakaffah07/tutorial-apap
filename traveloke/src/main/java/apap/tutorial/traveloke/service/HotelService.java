package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;

import java.util.List;

public interface HotelService {
    // Method untuk menambahkan Hotel
    void addHotel(HotelModel hotel);

    //Method untuk mendapatkan daftar Hotel yang telah tersimpan
    List<HotelModel> getHotelList();

    //Method untuk mendapatkan data sebuah hotel berdasarkan id hotel
    HotelModel getHotelByIdHotel(Long idHotel);

    // Method untuk update hotel
    HotelModel updateHotel(HotelModel hotel);

    //Method untuk update nomor telepon
    //HotelModel udpateNomorTeleponHotel(String idHotel, String noTeleponBaru);

    //Method untuk hapus hotel
    void deleteHotel(Long idHotel);


}
