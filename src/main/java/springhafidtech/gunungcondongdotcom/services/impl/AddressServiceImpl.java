package springhafidtech.gunungcondongdotcom.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.entities.Address;
import springhafidtech.gunungcondongdotcom.entities.Post;
import springhafidtech.gunungcondongdotcom.entities.User;
import springhafidtech.gunungcondongdotcom.exceptions.ResourceNotFoundException;
import springhafidtech.gunungcondongdotcom.payloads.AddressDto;
import springhafidtech.gunungcondongdotcom.payloads.PostDto;
import springhafidtech.gunungcondongdotcom.repositories.AddressRepo;
import springhafidtech.gunungcondongdotcom.repositories.UserRepo;
import springhafidtech.gunungcondongdotcom.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;


    @Override
    public AddressDto createAddress(AddressDto addressDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user id", userId));
        Address address = this.modelMapper.map(addressDto, Address.class);

        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setPostalCode(addressDto.getPostalCode());
        address.setCountry(addressDto.getCountry());
        address.setUser(user);

        Address newAddress = this.addressRepo.save(address);
        return this.modelMapper.map(newAddress, AddressDto.class);

    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, Integer userId) {
        Address address = this.addressRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Address", "user id", userId));

        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setPostalCode(addressDto.getPostalCode());
        address.setCity(addressDto.getCountry());
//        address.setUser(address);

        Address updateAddress = this.addressRepo.save(address);

        return this.modelMapper.map(updateAddress, AddressDto.class);


    }




}
