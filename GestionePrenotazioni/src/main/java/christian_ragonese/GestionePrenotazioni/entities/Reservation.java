package christian_ragonese.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter
@Setter
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
    private LocalDate res_date;

    public Reservation(Workstation workstation, User user, LocalDate res_date) {
        this.workstation = workstation;
        this.user = user;
        this.res_date = res_date;
    }
}
