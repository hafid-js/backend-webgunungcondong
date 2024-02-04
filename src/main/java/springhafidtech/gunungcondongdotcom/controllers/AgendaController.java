package springhafidtech.gunungcondongdotcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springhafidtech.gunungcondongdotcom.payloads.AddressDto;
import springhafidtech.gunungcondongdotcom.payloads.AgendaDto;
import springhafidtech.gunungcondongdotcom.services.AgendaService;

@RestController
@RequestMapping("/api/agenda/")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/")
    public ResponseEntity<AgendaDto> createAgenda (
            @RequestBody AgendaDto agendaDto) {
        AgendaDto createAgenda = this.agendaService.createAgenda(agendaDto);
        return new ResponseEntity<AgendaDto>(createAgenda, HttpStatus.CREATED);
    }
}
