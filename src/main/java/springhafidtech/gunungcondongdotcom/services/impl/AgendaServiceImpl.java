package springhafidtech.gunungcondongdotcom.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.entities.Agenda;
import springhafidtech.gunungcondongdotcom.exceptions.ResourceNotFoundException;
import springhafidtech.gunungcondongdotcom.payloads.AgendaDto;
import springhafidtech.gunungcondongdotcom.payloads.CategoryDto;
import springhafidtech.gunungcondongdotcom.repositories.AgendaRepo;
import springhafidtech.gunungcondongdotcom.services.AgendaService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepo agendaRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AgendaDto createAgenda(AgendaDto agendaDto) {

        Agenda agenda = this.modelMapper.map(agendaDto, Agenda.class);
        agenda.setTitle(agendaDto.getTitle());
        agenda.setEventSchedule(agendaDto.getEventSchedule());
        agenda.setLocation(agendaDto.getLocation());
        agenda.setCoordinator(agendaDto.getCoordinator());
        agenda.setPhone(agendaDto.getPhone());
        agenda.setDescription(agendaDto.getDescription());
        agenda.setCreatedAt(new Date());

        Agenda newAgenda = this.agendaRepo.save(agenda);

        return this.modelMapper.map(newAgenda, AgendaDto.class);
    }

    @Override
    public AgendaDto updateAgenda(AgendaDto agendaDto, Integer agendaId) {
        Agenda agenda = this.agendaRepo.findById(agendaId).orElseThrow(() -> new ResourceNotFoundException("Agenda", "agenda id", agendaId));
        agenda.setTitle(agendaDto.getTitle());
        agenda.setEventSchedule(agendaDto.getEventSchedule());
        agenda.setLocation(agendaDto.getLocation());
        agenda.setCoordinator(agendaDto.getCoordinator());
        agenda.setPhone(agendaDto.getPhone());
        agenda.setDescription(agendaDto.getDescription());
        agenda.setUpdatedAt(new Date());

        Agenda updateAgenda = this.agendaRepo.save(agenda);
        return this.modelMapper.map(updateAgenda, AgendaDto.class);
    }

    @Override
    public void deleteAgenda(Integer agendaId) {
        Agenda agenda = this.agendaRepo.findById(agendaId).orElseThrow(() -> new ResourceNotFoundException("Agenda", "agenda id", agendaId));
        this.agendaRepo.delete(agenda);
    }
    @Override
    public List<AgendaDto> getAgendas() {
        List<Agenda> agendas = this.agendaRepo.findAll();
        List<AgendaDto> agendaDtos = agendas.stream().map((agenda) -> this.modelMapper.map(agenda, AgendaDto.class)).collect(Collectors.toList());

        return agendaDtos;
    }

    @Override
    public AgendaDto getAgendaById(Integer agendaId) {
        Agenda agenda = this.agendaRepo.findById(agendaId).orElseThrow(() -> new ResourceNotFoundException("Agenda", "agenda id", agendaId));
        return this.modelMapper.map(agenda, AgendaDto.class);
    }
}
