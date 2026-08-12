package nick.project.polyrate.Transacao.Mapper;

import nick.project.polyrate.Transacao.Entity.TransacaoEntity;
import nick.project.polyrate.Transacao.Objects.dto.TransacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {

    @Mapping(source = "id", target = "idTransacao")
    @Mapping(source = "recebivel.id", target = "idRecebivel")
    @Mapping(source = "moedaPagamento.codigo", target = "codigoMoedaPagamento")
    TransacaoDTO toResponse(TransacaoEntity entity);

}
