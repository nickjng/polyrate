package nick.project.polyrate.TaxaCambio.Repository;

import nick.project.polyrate.TaxaCambio.Entity.TaxaCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface TaxaCambioRepository extends JpaRepository<TaxaCambioEntity, BigInteger> {

    Optional<TaxaCambioEntity> findTopByMoedaOrigem_IdAndMoedaDestino_IdOrderByDataReferenciaDesc(
            BigInteger moedaOrigemId, BigInteger moedaDestinoId
    );
}
