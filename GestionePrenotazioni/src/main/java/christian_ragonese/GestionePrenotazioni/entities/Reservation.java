package christian_ragonese.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Reservation {
    @ManyToOne
    @JoinColumn(name = "workstation_id")
    Workstation workstation;
    @ManyToOne
    @JoinColumn(name = "users_id")
    User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private LocalDate date;

    public Reservation(Workstation workstation, User user, LocalDate date) {
        this.workstation = workstation;
        this.user = user;
        this.date = date;
    }
}
