package nick.project.polyrate.Transacao.Repository;

import nick.project.polyrate.Transacao.Entity.TransacaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Integer> {

   Page<TransacaoEntity> findByCreatedAtBetween(LocalDateTime inicio, LocalDateTime fim, Pageable pageable);
}
