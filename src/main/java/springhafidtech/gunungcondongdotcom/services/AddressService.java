package springhafidtech.gunungcondongdotcom.services;

import springhafidtech.gunungcondongdotcom.payloads.AddressDto;
import springhafidtech.gunungcondongdotcom.payloads.UserDto;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto, Integer userId);

    AddressDto updateAddress(AddressDto addressDto, Integer userId);
}
