package pe.edu.cibertec.S2_OTARASEBASTIAN.model.bd;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="Medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmedico;
    private String nommedico;
    private String apemedico;
    @Column(name = "FechNacMedico")
    private java.time.LocalDate fechnacmedico;

}
