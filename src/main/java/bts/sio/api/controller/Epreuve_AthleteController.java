package bts.sio.api.controller;

import bts.sio.api.model.*;
import bts.sio.api.service.Epreuve_AthleteService;
import bts.sio.api.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Epreuve_AthleteController {

    @Autowired
    private Epreuve_AthleteService epreuve_AthleteService;

    @PostMapping("/epreuve_Athlete")
    public Epreuve_Athlete createEpreuve_Athlete(@RequestBody Epreuve_Athlete epreuve_Athlete) {
        return epreuve_AthleteService.saveEpreuve_Athlete(epreuve_Athlete);
    }

    @GetMapping("/epreuve_Athlete/{id}")
    public Epreuve_Athlete getEpreuve_Athlete(@PathVariable("id") final Long id) {
        Optional<Epreuve_Athlete> epreuve_Athlete = epreuve_AthleteService.getEpreuve_Athlete(id);
        if (epreuve_Athlete.isPresent()) {
            return epreuve_Athlete.get();
        } else {
            return null;
        }
    }

    @GetMapping("/epreuves_Athletes")
    public Iterable<Epreuve_Athlete> getEpreuve_Athletes() {
        return epreuve_AthleteService.getEpreuve_Athletes();
    }

    @PutMapping("/epreuve_Athlete/{id}")
    public Epreuve_Athlete updateEpreuve_Athlete(@PathVariable("id") final Long id, @RequestBody Epreuve_Athlete epreuve_athlete) {
        Optional<Epreuve_Athlete> e = epreuve_AthleteService.getEpreuve_Athlete(id);
        if (e.isPresent()) {
            Epreuve_Athlete currentEpreuve_Athlete = e.get();

            Epreuve epreuve = epreuve_athlete.getEpreuve();
            if (epreuve != null) {
                currentEpreuve_Athlete.setEpreuve(epreuve);
            }

            Athlete athlete = epreuve_athlete.getAthlete();
            if (athlete != null) {
                currentEpreuve_Athlete.setAthlete(athlete);
            }


            String place = epreuve_athlete.getPlace();
            if (place != null) {
                currentEpreuve_Athlete.setPlace(place);
            }

            epreuve_AthleteService.saveEpreuve_Athlete(currentEpreuve_Athlete);
            return currentEpreuve_Athlete;
        }  else {
            return null;
            }
        }


    @DeleteMapping("/epreuve_athlete/{id}")
    public void deleteEpreuve_Athlete(@PathVariable("id") final Long id) {
        epreuve_AthleteService.deleteEpreuve_Athlete(id);
    }

}
