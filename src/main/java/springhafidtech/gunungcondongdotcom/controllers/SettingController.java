package springhafidtech.gunungcondongdotcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springhafidtech.gunungcondongdotcom.payloads.SettingDto;
import springhafidtech.gunungcondongdotcom.services.SettingService;

@RestController
@RequestMapping("/api/setting/")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @PutMapping("/{settingId}")
    public ResponseEntity<SettingDto> updateSetting(@RequestBody SettingDto settingDto, @PathVariable Integer settingId) {
        SettingDto updateSetting = this.settingService.updateSetting(settingDto, settingId);
        return new ResponseEntity<SettingDto>(updateSetting, HttpStatus.OK);
    }
}
