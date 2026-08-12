package nick.project.polyrate.Moeda.Mapper;

import nick.project.polyrate.Moeda.Entity.MoedaEntity;
import nick.project.polyrate.Moeda.Objects.dao.MoedaDAO;
import nick.project.polyrate.Moeda.Objects.dto.MoedaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MoedaMapper {

    @Mapping(source = "codigo", target = "codigoMoeda")
    @Mapping(source = "nome", target = "nomeMoeda")
    MoedaDTO toResponse(MoedaEntity moedaEntity);
    MoedaEntity toEntity(MoedaDAO moedaDTO);

}
