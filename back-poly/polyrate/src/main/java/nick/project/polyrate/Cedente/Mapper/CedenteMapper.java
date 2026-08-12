package nick.project.polyrate.Cedente.Mapper;

import nick.project.polyrate.Cedente.Entity.CedenteEntity;
import nick.project.polyrate.Cedente.Objects.dao.CedenteDAO;
import nick.project.polyrate.Cedente.Objects.dto.CedenteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CedenteMapper {

    @Mapping(source = "id", target = "idCedente")
    @Mapping(source = "nome", target = "nomeCedente")
    @Mapping(source = "documento", target = "documentoCedente")
    CedenteDTO toResponse(CedenteEntity cedenteEntity);

    CedenteEntity toEntity(CedenteDAO cedenteDAO);
}
