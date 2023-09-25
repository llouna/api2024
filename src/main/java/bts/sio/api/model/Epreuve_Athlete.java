package bts.sio.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Epreuve_Athlete")

public class Epreuve_Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "epreuve_id")
    private Epreuve epreuve;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @Column(name = "place")
    private String place;

}
