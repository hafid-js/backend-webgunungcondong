package springhafidtech.gunungcondongdotcom.services;

import springhafidtech.gunungcondongdotcom.payloads.OfficialDto;

import java.util.List;

public interface OfficialService {

    OfficialDto createOfficial(OfficialDto officialDto);

    OfficialDto updateOfficial(OfficialDto officialDto, Integer officialId);

    void deleteOfficial(Integer officialId);

    OfficialDto getOfficial(Integer officialId);

    List<OfficialDto> getOfficials();


}
