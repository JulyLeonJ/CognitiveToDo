package org.example.infrastructure.adapter.mapper;

import org.example.infrastructure.entities.TaskEntity;
import org.example.domain.model.Task;
import org.example.usecase.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TaskMapper {
    Task toModel(TaskEntity entities);
    TaskEntity toEntity(Task Model);
    TaskDto toDto(Task domain);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mandatory", defaultValue = "false")
    @Mapping(target = "state", defaultValue = "0")
    Task toDomain(TaskDto dto);
}
