package springhafidtech.gunungcondongdotcom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springhafidtech.gunungcondongdotcom.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
