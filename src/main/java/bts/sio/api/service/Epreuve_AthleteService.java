package bts.sio.api.service;

import bts.sio.api.model.Epreuve_Athlete;
import bts.sio.api.repository.Epreuve_AthleteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class Epreuve_AthleteService {

    @Autowired
    private Epreuve_AthleteRepository epreuve_athleteRepository;

    public Optional<Epreuve_Athlete> getEpreuve_Athlete(final Long id) { return epreuve_athleteRepository.findById(id);}

    public Iterable<Epreuve_Athlete> getEpreuve_Athletes() {
        return epreuve_athleteRepository.findAll();
    }

    public void deleteEpreuve_Athlete(final Long id) {
        epreuve_athleteRepository.deleteById(id);
    }

    public Epreuve_Athlete saveEpreuve_Athlete(Epreuve_Athlete epreuve_Athlete) {
        Epreuve_Athlete savedEpreuve_Athlete = epreuve_athleteRepository.save(epreuve_Athlete);
        return savedEpreuve_Athlete;

    }


}
