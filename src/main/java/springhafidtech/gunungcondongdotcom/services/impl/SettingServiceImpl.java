package springhafidtech.gunungcondongdotcom.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.entities.Setting;
import springhafidtech.gunungcondongdotcom.exceptions.ResourceNotFoundException;
import springhafidtech.gunungcondongdotcom.payloads.SettingDto;
import springhafidtech.gunungcondongdotcom.repositories.SettingRepo;
import springhafidtech.gunungcondongdotcom.services.SettingService;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingRepo settingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SettingDto updateSetting(SettingDto settingDto, Integer settingId) {
        Setting set = this.settingRepo.findById(settingId)
                .orElseThrow(() -> new ResourceNotFoundException("Setting", "setting id", settingId));

        set.setTitle(settingDto.getTitle());
        set.setLogo(settingDto.getLogo());
        set.setEmail(settingDto.getEmail());
        set.setFullAddress(settingDto.getFullAddress());
        set.setPhone(settingDto.getPhone());
        set.setFacebook(settingDto.getFacebook());
        set.setYoutube(settingDto.getYoutube());
        set.setInstagram(settingDto.getInstagram());
        set.setYoutubeLinksWidget(settingDto.getYoutubeLinksWidget());

        Setting updateSet = this.settingRepo.save(set);

        return this.modelMapper.map(updateSet, settingDto.getClass());
    }
}
