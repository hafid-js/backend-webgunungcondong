package springhafidtech.gunungcondongdotcom.services;

import springhafidtech.gunungcondongdotcom.payloads.GalleryDto;

import java.util.List;

public interface GalleryService {

    GalleryDto createGallery(GalleryDto galleryDto, Integer galleryCategoryId);

    void deleteGallery(Integer galleryId);

    List<GalleryDto> getGalleries();

    GalleryDto getGallery(Integer galleryId);


}
