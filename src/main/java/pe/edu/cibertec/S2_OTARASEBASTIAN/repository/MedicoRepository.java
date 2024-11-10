package pe.edu.cibertec.S2_OTARASEBASTIAN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.S2_OTARASEBASTIAN.model.bd.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
