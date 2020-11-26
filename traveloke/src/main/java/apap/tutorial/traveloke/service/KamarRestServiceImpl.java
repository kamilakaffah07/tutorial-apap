package apap.tutorial.traveloke.service;


import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService {

    @Autowired
    private KamarDb kamarDb;

    @Override
    public KamarModel createKamar(KamarModel kamar){ return kamarDb.save(kamar);}

    @Override
    public List<KamarModel> retrieveListKamar(){return kamarDb.findAll();}

    @Override
    public KamarModel getKamarByNomorKamar(Long idKamar){
        Optional<KamarModel> kamar = kamarDb.findByNoKamar(idKamar);
        if(kamar.isPresent()){
            return kamar.get();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public KamarModel changeKamar(Long idKamar, KamarModel kamarUpdate){
        KamarModel kamar = getKamarByNomorKamar(idKamar);
        kamar.setNamaKamar(kamarUpdate.getNamaKamar());
        kamar.setTipe(kamarUpdate.getTipe());
        kamar.setKapasitasKamar(kamarUpdate.getKapasitasKamar());
        return kamarDb.save(kamar);
    }

    @Override
    public void deleteKamar(Long idKamar){
        KamarModel kamar = getKamarByNomorKamar(idKamar);
        kamarDb.delete(kamar);
    }

}
