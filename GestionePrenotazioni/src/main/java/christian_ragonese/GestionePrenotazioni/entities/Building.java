package christian_ragonese.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "buildings")
@Getter
@Setter
@NoArgsConstructor

public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    private List<Workstation> workstaionList;

    public Building(String name, String address, String city, List<Workstation> workstaionList) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.workstaionList = workstaionList;
    }
}
