package com.oliveirajoao.agendadortarefas.business.mapper;

import com.oliveirajoao.agendadortarefas.business.dto.TarefasDTO;
import com.oliveirajoao.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefasEntity(TarefasDTO dto);

    TarefasDTO paraTarefasDTO(TarefasEntity entity);
}
