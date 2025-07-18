package christian_ragonese.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservationList;

    public User(String username, String name, String surname, String email, List<Reservation> reservationList) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.reservationList = reservationList;
    }

}
