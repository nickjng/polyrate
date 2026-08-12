package nick.project.polyrate.TipoRecebivel.Mapper;

import nick.project.polyrate.TipoRecebivel.Entity.TipoRecebivelEntity;
import nick.project.polyrate.TipoRecebivel.Objects.dao.TipoRecebivelDAO;
import nick.project.polyrate.TipoRecebivel.Objects.dto.TipoRecebivelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoRecebivelMapper {

    @Mapping(source = "id", target = "idTipoRecebivel")
    @Mapping(source = "nome", target = "nomeTipoRecebivel")
    TipoRecebivelDTO toResponse(TipoRecebivelEntity entity);

    TipoRecebivelEntity toEntity(TipoRecebivelDAO dao);
}
