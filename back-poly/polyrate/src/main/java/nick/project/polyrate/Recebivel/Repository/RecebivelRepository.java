package nick.project.polyrate.Recebivel.Repository;

import nick.project.polyrate.Recebivel.Entity.RecebivelEntity;
import nick.project.polyrate.Recebivel.Objects.enums.StatusRecebivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface RecebivelRepository extends JpaRepository<RecebivelEntity, Integer> {

    List<RecebivelEntity> findByStatus(StatusRecebivel status);
    List<RecebivelEntity> findByCedente_IdCedente(Integer cedenteId);
}
