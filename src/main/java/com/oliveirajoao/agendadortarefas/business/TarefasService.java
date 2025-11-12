package com.oliveirajoao.agendadortarefas.business;

import com.oliveirajoao.agendadortarefas.business.dto.TarefasDTO;
import com.oliveirajoao.agendadortarefas.business.mapper.TarefasConverter;
import com.oliveirajoao.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.oliveirajoao.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.oliveirajoao.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.oliveirajoao.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefasEntity(dto);

        return tarefaConverter.paraTarefasDTO(
                tarefasRepository.save(entity));
    }
}

