package github.haozi.uauth.service.mapper;

import github.haozi.uauth.domain.ProfileEntity;
import github.haozi.uauth.service.dto.ProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-30 14:04
 */
@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "accountName", target = "accountName")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "sex", target = "sex")
    ProfileDTO entityToDto(ProfileEntity entity);

    List<ProfileDTO> entitiesToDtos(List<ProfileEntity> entities);

    List<ProfileEntity> dtosToEntities(List<ProfileDTO> dtos);

    ProfileEntity dtoToEntity(ProfileDTO profileDTO);

    void updateEntityFromDto(ProfileDTO profileDTO, @MappingTarget ProfileEntity entity);

    void updateDtoFromEntity(ProfileEntity profileEntity, @MappingTarget ProfileDTO profileDTO);
}
