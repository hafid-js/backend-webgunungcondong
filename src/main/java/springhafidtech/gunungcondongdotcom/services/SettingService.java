package springhafidtech.gunungcondongdotcom.services;

import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.payloads.SettingDto;

public interface SettingService {

    SettingDto updateSetting(SettingDto settingDto, Integer settingId);
}
