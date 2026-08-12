package nick.project.polyrate.TaxaCambio.Mapper;

import nick.project.polyrate.TaxaCambio.Entity.TaxaCambioEntity;
import nick.project.polyrate.TaxaCambio.Objects.dto.TaxaCambioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaxaCambioMapper {

    @Mapping(source = "moedaOrigem.codigo", target = "codigoMoedaOrigem")
    @Mapping(source = "moedaDestino.codigo", target = "codigoMoedaDestino")
    TaxaCambioDTO toResponse(TaxaCambioEntity entity);
}
