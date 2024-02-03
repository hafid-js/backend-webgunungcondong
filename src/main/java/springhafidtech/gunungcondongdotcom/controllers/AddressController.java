package springhafidtech.gunungcondongdotcom.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springhafidtech.gunungcondongdotcom.payloads.AddressDto;
import springhafidtech.gunungcondongdotcom.payloads.CategoryDto;
import springhafidtech.gunungcondongdotcom.services.AddressService;

@RestController
@RequestMapping("/api/user/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/{userId}/address")
    public ResponseEntity<AddressDto> createAddress(
            @RequestBody AddressDto addressDto,
            @PathVariable Integer userId) {
        AddressDto createAddress = this.addressService.createAddress(addressDto, userId);
        return new ResponseEntity<AddressDto>(createAddress, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto addressDto, @PathVariable Integer userId) {
        AddressDto updateAddress = this.addressService.updateAddress(addressDto, userId);
        return new ResponseEntity<AddressDto>(updateAddress, HttpStatus.OK);
    }



}
