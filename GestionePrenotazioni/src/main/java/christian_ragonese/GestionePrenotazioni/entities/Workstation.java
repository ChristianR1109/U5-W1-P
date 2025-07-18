package christian_ragonese.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "workstations")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String description;
    private WorkstationType type;
    @Column(name = "max_people")
    private int n_max;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @OneToMany(mappedBy = "workstation")
    private List<Reservation> reservationsList;
    public Workstation(String description, WorkstationType type, int n_max, Building building, List<Reservation> reservationsList) {
        this.description = description;
        this.type = type;
        this.n_max = n_max;
        this.building = building;
        this.reservationsList = reservationsList;
    }
}
