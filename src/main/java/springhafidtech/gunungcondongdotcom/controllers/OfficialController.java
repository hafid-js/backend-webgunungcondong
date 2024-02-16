package springhafidtech.gunungcondongdotcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springhafidtech.gunungcondongdotcom.payloads.ApiResponse;
import springhafidtech.gunungcondongdotcom.payloads.OfficialDto;
import springhafidtech.gunungcondongdotcom.services.OfficialService;

import java.util.List;

@RestController
@RequestMapping("/api/official/")
public class OfficialController {

    @Autowired
    private OfficialService officialService;

    @PostMapping("/")
    public ResponseEntity<OfficialDto> createOfficial(@RequestBody OfficialDto officialDto) {
        OfficialDto createOfficial = this.officialService.createOfficial(officialDto);
        return new ResponseEntity<OfficialDto>(createOfficial, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<OfficialDto>> getOfficials() {
        List<OfficialDto> officials = this.officialService.getOfficials();
        return ResponseEntity.ok(officials);
    }

    @GetMapping("/{officialId}")
    public ResponseEntity<OfficialDto> getOfficial(@PathVariable Integer officialId) {

        OfficialDto officialDto = this.officialService.getOfficial(officialId);
        return new ResponseEntity<OfficialDto>(officialDto, HttpStatus.OK);
    }

    @PutMapping("/{officialId}")
    public ResponseEntity<OfficialDto> updateOfficial(@RequestBody OfficialDto officialDto, @PathVariable Integer officialId) {
        OfficialDto updateOfficial = this.officialService.updateOfficial(officialDto, officialId);
        return new ResponseEntity<OfficialDto>(updateOfficial, HttpStatus.OK);
    }

    @DeleteMapping("/{officialId}")
    public ResponseEntity<ApiResponse> deleteOfficial(@PathVariable Integer officialId) {
        this.officialService.deleteOfficial(officialId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("official is deleted successfully !", true), HttpStatus.OK);
    }
}
