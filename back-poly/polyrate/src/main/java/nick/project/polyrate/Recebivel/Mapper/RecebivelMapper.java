package nick.project.polyrate.Recebivel.Mapper;

import nick.project.polyrate.Recebivel.Entity.RecebivelEntity;
import nick.project.polyrate.Recebivel.Objects.dto.RecebivelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecebivelMapper {

    @Mapping(source = "cedente.nome", target = "nomeCedente")
    @Mapping(source = "tipoRecebivel.nome", target = "nomeTipoRecebivel")
    @Mapping(source = "moedaTitulo.codigo", target = "codigoMoedaTitulo")
    RecebivelDTO toResponse(RecebivelEntity entity);

    // Assim como em TaxaCambio: sem toEntity(RecebivelDAO) aqui. cedenteId,
    // tipoRecebivelId e moedaTituloId são IDs — quem resolve pra entidade
    // de verdade (via repository.findById) é o ServiceImpl.
}
