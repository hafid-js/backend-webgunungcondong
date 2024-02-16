package springhafidtech.gunungcondongdotcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springhafidtech.gunungcondongdotcom.payloads.AddressDto;
import springhafidtech.gunungcondongdotcom.payloads.AgendaDto;
import springhafidtech.gunungcondongdotcom.payloads.ApiResponse;
import springhafidtech.gunungcondongdotcom.services.AgendaService;

import java.util.List;

@RestController
@RequestMapping("/api/agenda/")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping("/")
    public ResponseEntity<List<AgendaDto>> getAgendas() {
        List<AgendaDto> agendas = this.agendaService.getAgendas();
        return ResponseEntity.ok(agendas);
    }

    @PostMapping("/")
    public ResponseEntity<AgendaDto> createAgenda (
            @RequestBody AgendaDto agendaDto) {
        AgendaDto createAgenda = this.agendaService.createAgenda(agendaDto);
        return new ResponseEntity<AgendaDto>(createAgenda, HttpStatus.CREATED);
    }

    @PutMapping("/{agendaId}")
    public ResponseEntity<AgendaDto> updateAgenda(
            @RequestBody AgendaDto agendaDto,
            @PathVariable Integer agendaId
    ) {
        AgendaDto updateAgenda = this.agendaService.updateAgenda(agendaDto, agendaId);
        return new ResponseEntity<AgendaDto>(updateAgenda, HttpStatus.OK);
    }

    @GetMapping("/{agendaId}")
    public ResponseEntity<AgendaDto> getAgenda(@PathVariable Integer agendaId) {
        AgendaDto agendaDto = this.agendaService.getAgendaById(agendaId);
        return new ResponseEntity<AgendaDto>(agendaDto, HttpStatus.OK);
    }

    @DeleteMapping("/{agendaId}")
    public ResponseEntity<ApiResponse> deleteAgenda(@PathVariable Integer agendaId) {
        this.agendaService.deleteAgenda(agendaId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("agenda is deleted successfully !!", true), HttpStatus.OK);
    }
}
