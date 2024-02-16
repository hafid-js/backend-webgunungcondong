package springhafidtech.gunungcondongdotcom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springhafidtech.gunungcondongdotcom.entities.Agenda;
import springhafidtech.gunungcondongdotcom.entities.VillageOfficial;

public interface OfficialRepo extends JpaRepository<VillageOfficial, Integer> {
}
