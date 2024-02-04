package springhafidtech.gunungcondongdotcom.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.entities.Agenda;
import springhafidtech.gunungcondongdotcom.payloads.AgendaDto;
import springhafidtech.gunungcondongdotcom.repositories.AgendaRepo;
import springhafidtech.gunungcondongdotcom.services.AgendaService;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepo agendaRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AgendaDto createAgenda(AgendaDto agendaDto) {
        Agenda agenda = this.modelMapper.map(agendaDto, Agenda.class);
        Agenda addAgenda = this.agendaRepo.save(agenda);

        return this.modelMapper.map(addAgenda, AgendaDto.class);
    }

    @Override
    public AgendaDto updateAgenda(AgendaDto agendaDto, Integer agendaId) {
        return null;
    }

    @Override
    public void deleteAgenda(Integer agendaId) {

    }

    @Override
    public List<AgendaDto> getAgendas() {
        return null;
    }

    @Override
    public AgendaDto getAgendaById(Integer agendaId) {
        return null;
    }
}
