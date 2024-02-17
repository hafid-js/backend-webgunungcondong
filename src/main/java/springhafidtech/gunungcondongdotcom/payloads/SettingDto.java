package springhafidtech.gunungcondongdotcom.payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SettingDto {

    private Integer settingId;

    private String title;

    private String logo;

    private String email;

    private String fullAddress;

    private String phone;

    private String facebook;

    private String youtube;

    private String instagram;

    private String[] youtubeLinksWidget;

}
