package nick.project.polyrate.Cedente.Repository;

import nick.project.polyrate.Cedente.Entity.CedenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CedenteRepository extends JpaRepository<CedenteEntity, Integer> {

    Optional<CedenteEntity> findByDocumento(String documento);
}
