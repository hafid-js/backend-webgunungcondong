package springhafidtech.gunungcondongdotcom.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springhafidtech.gunungcondongdotcom.entities.User;

@NoArgsConstructor
@Setter
@Getter
public class AddressDto {

    private Integer addressId;

    private String city;

    private String country;

    private String postalCode;

    private String street;

    private UserDto user;





}
