package springhafidtech.gunungcondongdotcom.services;

import springhafidtech.gunungcondongdotcom.entities.Agenda;
import springhafidtech.gunungcondongdotcom.payloads.AgendaDto;
import springhafidtech.gunungcondongdotcom.payloads.CategoryDto;
import springhafidtech.gunungcondongdotcom.payloads.PostResponse;

import java.util.List;

public interface AgendaService {

    AgendaDto createAgenda(AgendaDto agendaDto);

    AgendaDto updateAgenda(AgendaDto agendaDto, Integer agendaId);

    void deleteAgenda(Integer agendaId);

    List<AgendaDto> getAgendas();

    AgendaDto getAgendaById(Integer agendaId);

}
