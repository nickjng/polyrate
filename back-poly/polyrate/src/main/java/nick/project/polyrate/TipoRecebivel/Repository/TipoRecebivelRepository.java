package nick.project.polyrate.TipoRecebivel.Repository;

import nick.project.polyrate.TipoRecebivel.Entity.TipoRecebivelEntity;
import nick.project.polyrate.TipoRecebivel.Objects.enums.CodigoEstrategia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface TipoRecebivelRepository extends JpaRepository<TipoRecebivelEntity, BigInteger> {

    Optional<TipoRecebivelEntity> findByCodigoEstrategia(CodigoEstrategia codigoEstrategia);
}
