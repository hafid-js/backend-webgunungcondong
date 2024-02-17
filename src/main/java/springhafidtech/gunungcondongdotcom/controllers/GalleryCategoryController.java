package springhafidtech.gunungcondongdotcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springhafidtech.gunungcondongdotcom.payloads.ApiResponse;
import springhafidtech.gunungcondongdotcom.payloads.GalleryCategoryDto;
import springhafidtech.gunungcondongdotcom.services.GalleryCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/gallery-categories")
public class GalleryCategoryController {

    @Autowired
    private GalleryCategoryService galleryCategoryService;

    @PostMapping("/")
    public ResponseEntity<GalleryCategoryDto> createCategory(@RequestBody GalleryCategoryDto galleryCategoryDto) {
        GalleryCategoryDto createCategory = this.galleryCategoryService.createCategory(galleryCategoryDto);
        return new ResponseEntity<GalleryCategoryDto>(createCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{galleryCategoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer galleryCategoryId) {
        this.galleryCategoryService.deleteCategory(galleryCategoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true), HttpStatus.OK);
    }

    @GetMapping("/{galleryCategoryId")
    public ResponseEntity<GalleryCategoryDto> getCategory(@PathVariable Integer galleryCategoryId) {
        GalleryCategoryDto categoryDto = this.galleryCategoryService.getCategory(galleryCategoryId);
        return new ResponseEntity<GalleryCategoryDto>(categoryDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<GalleryCategoryDto>> getCategories() {
        List<GalleryCategoryDto> categories = this.galleryCategoryService.getCategories();
        return ResponseEntity.ok(categories);
    }



}
