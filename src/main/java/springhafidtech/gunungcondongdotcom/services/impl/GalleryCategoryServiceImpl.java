package springhafidtech.gunungcondongdotcom.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.entities.GalleryCategory;
import springhafidtech.gunungcondongdotcom.exceptions.ResourceNotFoundException;
import springhafidtech.gunungcondongdotcom.payloads.GalleryCategoryDto;
import springhafidtech.gunungcondongdotcom.repositories.GalleryCategoryRepo;
import springhafidtech.gunungcondongdotcom.services.GalleryCategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GalleryCategoryServiceImpl implements GalleryCategoryService {

    @Autowired
    private GalleryCategoryRepo galleryCategoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GalleryCategoryDto createCategory(GalleryCategoryDto galleryCategoryDto) {
        GalleryCategory category = this.modelMapper.map(galleryCategoryDto, GalleryCategory.class);
        GalleryCategory addCategory = this.galleryCategoryRepo.save(category);

        return this.modelMapper.map(addCategory, GalleryCategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer galleryCategoryId) {
        GalleryCategory category = this.galleryCategoryRepo.findById(galleryCategoryId).orElseThrow(() -> new ResourceNotFoundException("GalleryCategory", "gallery category id", galleryCategoryId));
        this.galleryCategoryRepo.delete(category);

    }

    @Override
    public GalleryCategoryDto getCategory(Integer galleryCategoryId) {
        GalleryCategory category = this.galleryCategoryRepo.findById(galleryCategoryId).orElseThrow(() -> new ResourceNotFoundException("GalleryCategory", "gallery category id", galleryCategoryId));
        return this.modelMapper.map(category, GalleryCategoryDto.class);
    }

    @Override
    public List<GalleryCategoryDto> getCategories() {
        List<GalleryCategory> categories = this.galleryCategoryRepo.findAll();
        List<GalleryCategoryDto> categoryDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, GalleryCategoryDto.class)).collect(Collectors.toList());

        return categoryDtos;
    }
}
