package springhafidtech.gunungcondongdotcom.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.entities.VillageOfficial;
import springhafidtech.gunungcondongdotcom.exceptions.ResourceNotFoundException;
import springhafidtech.gunungcondongdotcom.payloads.OfficialDto;
import springhafidtech.gunungcondongdotcom.repositories.OfficialRepo;
import springhafidtech.gunungcondongdotcom.services.OfficialService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OfficialServiceImpl implements OfficialService {

    @Autowired
    private OfficialRepo officialRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OfficialDto createOfficial(OfficialDto officialDto) {

        VillageOfficial official = this.modelMapper.map(officialDto, VillageOfficial.class);
        official.setName(officialDto.getName());
        official.setPosition(officialDto.getPosition());
        official.setRegisNumber(officialDto.getRegisNumber());
        official.setImage(officialDto.getImage());

        VillageOfficial newOfficial = this.officialRepo.save(official);

        return this.modelMapper.map(newOfficial, OfficialDto.class);
    }

    @Override
    public OfficialDto updateOfficial(OfficialDto officialDto, Integer officialId) {
       VillageOfficial official = this.officialRepo.findById(officialId)
               .orElseThrow(() -> new ResourceNotFoundException("VillageOfficial", "official id", officialId));

       official.setName(officialDto.getName());
       official.setPosition(officialDto.getPosition());
       official.setRegisNumber(officialDto.getRegisNumber());
       official.setImage(officialDto.getImage());

       VillageOfficial updateOfficial = this.officialRepo.save(official);
       return this.modelMapper.map(updateOfficial, officialDto.getClass());
    }

    @Override
    public void deleteOfficial(Integer officialId) {
        VillageOfficial official = this.officialRepo.findById(officialId).orElseThrow(()-> new ResourceNotFoundException("VillageOfficial", "official id", officialId));
        this.officialRepo.delete(official);
    }

    @Override
    public OfficialDto getOfficial(Integer officialId) {
        VillageOfficial official = this.officialRepo.findById(officialId).orElseThrow(() -> new ResourceNotFoundException("VillageOfficial", "official id", officialId));
        return this.modelMapper.map(official, OfficialDto.class);
    }

    @Override
    public List<OfficialDto> getOfficials() {
       List<VillageOfficial> officials = this.officialRepo.findAll();
       List<OfficialDto> officialDtos = officials.stream().map((official) -> this.modelMapper.map(official, OfficialDto.class)).collect(Collectors.toList());
       return officialDtos;
    }
}
