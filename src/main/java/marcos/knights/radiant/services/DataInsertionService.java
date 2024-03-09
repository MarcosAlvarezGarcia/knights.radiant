package marcos.knights.radiant.services;


import lombok.RequiredArgsConstructor;
import marcos.knights.radiant.models.Role;
import marcos.knights.radiant.models.Surge;
import marcos.knights.radiant.services.surge.SurgeService;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;



import java.util.Locale;

@Service
@RequiredArgsConstructor
public class DataInsertionService {
    private final SurgeService surgeService;

    private final Faker faker = new Faker(new Locale("es-ES"));



    public void createSurges(int number){
        if(number <= 0) return;
        for(int i = 0; i < number; i++){
            Surge surge = new Surge(
                    null,
                    faker.cosmere().surges(),
                    faker.lorem().sentence(5),
                    Role.FIRST_IDEAL
            );
            surgeService.save(surge);
        }
    }

}
