package springhafidtech.gunungcondongdotcom.services;

import springhafidtech.gunungcondongdotcom.payloads.GalleryCategoryDto;

import java.util.List;

public interface GalleryCategoryService {

    GalleryCategoryDto createCategory(GalleryCategoryDto galleryCategoryDto);

    void deleteCategory(Integer galleryCategoryId);

    GalleryCategoryDto getCategory(Integer galleryCategoryId);

    List<GalleryCategoryDto> getCategories();
}
