package springhafidtech.gunungcondongdotcom.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.entities.Gallery;
import springhafidtech.gunungcondongdotcom.entities.GalleryCategory;
import springhafidtech.gunungcondongdotcom.exceptions.ResourceNotFoundException;
import springhafidtech.gunungcondongdotcom.payloads.GalleryDto;
import springhafidtech.gunungcondongdotcom.repositories.GalleryCategoryRepo;
import springhafidtech.gunungcondongdotcom.repositories.GalleryRepo;
import springhafidtech.gunungcondongdotcom.services.GalleryService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepo galleryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GalleryCategoryRepo galleryCategoryRepo;

    @Override
    public GalleryDto createGallery(GalleryDto galleryDto, Integer galleryCategoryId) {

        GalleryCategory category = this.galleryCategoryRepo.findById(galleryCategoryId).orElseThrow(() -> new ResourceNotFoundException("GalleryCategory", "gallery category id", galleryCategoryId));


        Gallery gallery = this.modelMapper.map(galleryDto, Gallery.class);
        gallery.setImage(galleryDto.getImage());
        gallery.setGalleryCategory(category);
        gallery.setCreatedAt(new Date());

        Gallery newGal = this.galleryRepo.save(gallery);
        return this.modelMapper.map(newGal, GalleryDto.class);

    }

    @Override
    public void deleteGallery(Integer galleryId) {
        Gallery gallery = this.galleryRepo.findById(galleryId).orElseThrow(() -> new ResourceNotFoundException("Gallery", "gallery id" , galleryId));
        this.galleryRepo.delete(gallery);

    }

    @Override
    public List<GalleryDto> getGalleries() {
        List<Gallery> galleries = this.galleryRepo.findAll();
        List<GalleryDto> galleryDtos = galleries.stream().map(gallery -> this.modelMapper.map(gallery, GalleryDto.class)).collect(Collectors.toList());
        return galleryDtos;
    }

    @Override
    public GalleryDto getGallery(Integer galleryId) {
        Gallery gallery = this.galleryRepo.findById(galleryId).orElseThrow(() -> new ResourceNotFoundException("Gallery", "gallery id", galleryId));
        return this.modelMapper.map(gallery, GalleryDto.class);
    }
}
