package marcos.knights.radiant.services;


import lombok.RequiredArgsConstructor;
import marcos.knights.radiant.dtos.user.UserDtoCreate;
import marcos.knights.radiant.models.*;
import marcos.knights.radiant.services.message.MessageService;
import marcos.knights.radiant.services.mission.MissionService;
import marcos.knights.radiant.services.radiantOrder.RadiantOrderService;
import marcos.knights.radiant.services.surge.SurgeService;
import marcos.knights.radiant.services.task.TaskService;
import marcos.knights.radiant.services.user.UserService;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class DataInsertionService {
    private final SurgeService surgeService;
    private final RadiantOrderService radiantOrderService;
    private final MessageService messageService;
    private final TaskService taskService;
    private final MissionService missionService;
    private final UserService userService;

    private final Faker faker = new Faker(new Locale("es-ES"));

    public void createSurges(int amount){
        String[] SurgesName = {
                "Adhesion",
                "Gravitation",
                "Division",
                "Abrasion",
                "Progression",
                "Ilumination",
                "Transformation",
                "Transportation",
                "Cohesion",
                "Tension"
        };
        String[] SurgesDescription = {
                "The Surge of Adhesion can be manipulated to bind things together.",
                "The Surge of Gravitation can be manipulated to change the direction and strength of an object's gravitational attraction.",
                "The Surge of Division can be manipulated to have power over destruction and decay.",
                "The Surge of Abrasion can be manipulated to alter the frictional force between two surfaces.",
                "The Surge of Progression can be manipulated to alter the growth and healing of organisms.",
                "The Surge of Ilumination can be manipulated to create auditory and visual ilusions.",
                "The Surge of Transformation can be manipulated to change an object into one of the ten essences.",
                "The Surge of Transportation can be manipulated to achieve realmatic transition.",
                "The Surge of Cohesion can be manipulated to alter objects at a molecular level.",
                "The Surge of Tension can be manipulated to alter the stiffness of an object."
        };

        Ideal[] SurgesIdeal = {
                Ideal.NO_IDEAL,
                Ideal.SECOND_IDEAL,
                Ideal.THIRD_IDEAL,
                Ideal.FIRST_IDEAL,
                Ideal.SECOND_IDEAL,
                Ideal.NO_IDEAL,
                Ideal.NO_IDEAL,
                Ideal.SECOND_IDEAL,
                Ideal.FIRST_IDEAL,
                Ideal.SECOND_IDEAL
        };
        if(amount <= 0) return;
        for(int i = 0; i < amount; i++){
            Surge surge = new Surge(
                    null,
                    SurgesName[i],
                    SurgesDescription[i],
                    SurgesIdeal[i]
            );
            surgeService.save(surge);
        }
    }

    public void createOrders(int amount){
        String[] OrdersName = {
                "Windrunners",
                "Skybreakers",
                "Dustbringers",
                "Edgedancers",
                "Truthwatchers",
                "Ligthweavers",
                "Elsecallers",
                "Willshapers",
                "Stonewards",
                "Bondsmiths"
        };
        String[] OrdersSprenType = {
                "Honorspren",
                "Highspren",
                "Ashpren",
                "Cultivationspren",
                "Mistspren",
                "Liespren (Cryptic)",
                "Inkspren",
                "Ligthspren (Reachers)",
                "Peakspren",
                "Stormfather, Nightwatcher and Sibling"
        };
        String[] OrdersDescription = {
                "Those who join the Windrunners generally subscribe to a philosophy of protection.",
                "The individuals who join the Skybreakers generally believe in following a strong moral code.",
                "The Dustbringers believe that great power requires a strong will to control it, and their oaths are designed to teach them to control their destructive power.",
                "Edgedancers generally subscribe to a philosophy of remembering the ordinary people of the world.",
                "Those who join the Truthwatchers generally subscribe to a philosophy of finding the ultimate truth and sharing it.",
                "While each order of Radiants contains a variety of personalities within it, those who join the Lightweavers generally subscribe to a philosophy of speaking truths about themselves that they must admit in order to progress as people.",
                "Those who join the Elsecallers generally subscribe to a philosophy that they should be becoming better with each oath, seeking to explore their true potential and reach it.",
                "Willshapers generally subscribe to a philosophy that all people should be free to make their own choices.",
                "Those who join the Stonewards generally subscribe to a philosophy of team dynamics, on learning to work with others, and on being there for those who need them.",
                "While each order of Radiants contains a variety of personalities within it, those who join the Bondsmiths generally subscribe to a philosophy of peace and unity."
        };
        String[] OrdersAttributes = {
                "Protecting and leading",
                "Just and confident",
                "Brave and obedient",
                "Loving and healing",
                "Learned and giving",
                "Creative and honest",
                "Wise and careful",
                "Resolute and builder",
                "Dependable and resourceful",
                "Pious and guiding"
        };
        Surge surge1 = surgeService.findById((long)1);
        Surge surge2 = surgeService.findById((long)2);
        Surge surge3 = surgeService.findById((long)3);
        Surge surge4 = surgeService.findById((long)4);
        Surge surge5 = surgeService.findById((long)5);
        Surge surge6 = surgeService.findById((long)6);
        Surge surge7 = surgeService.findById((long)7);
        Surge surge8 = surgeService.findById((long)8);
        Surge surge9 = surgeService.findById((long)9);
        Surge surge10 = surgeService.findById((long)10);

        List<Surge> Windrunners = List.of(new Surge[]{
            surge1,
            surge2
        });
        List<Surge> Skybreakers = List.of(new Surge[]{
            surge2,
            surge3
        });
        List<Surge> Dustbringers = List.of(new Surge[]{
            surge3,
            surge4
        });
        List<Surge> Edgedancers = List.of(new Surge[]{
            surge4,
            surge5
        });
        List<Surge> Truthwatchers = List.of(new Surge[]{
            surge5,
            surge6
        });
        List<Surge> Ligthweavers = List.of(new Surge[]{
            surge6,
            surge7
        });
        List<Surge> Elsecallers = List.of(new Surge[]{
            surge7,
            surge8
        });
        List<Surge> Willshapers = List.of(new Surge[]{
            surge8,
            surge9
        });
        List<Surge> Stonewards = List.of(new Surge[]{
            surge9,
            surge10
        });
        List<Surge> Bondsmiths = List.of(new Surge[]{
            surge10,
            surge1
        });

        List[] OrdersSurges = {
                Windrunners,
                Skybreakers,
                Dustbringers,
                Edgedancers,
                Truthwatchers,
                Ligthweavers,
                Elsecallers,
                Willshapers,
                Stonewards,
                Bondsmiths
        };

        List<Surge> surges = surgeService.findAll();
        if(amount <= 0) return;
        for(int i = 0; i < amount; i++){
            RadiantOrder order = new RadiantOrder(
                    null,
                    OrdersName[i],
                    OrdersSprenType[i],
                    OrdersDescription[i],
                    OrdersAttributes[i],
                    OrdersSurges[i]
            );
            radiantOrderService.save(order);
        }
    }

    public void createMessages(int amount){
        if(amount <= 0) return;
        for(int i = 0; i < amount; i++){
            Message message = new Message(
                    null,
                    null,
                    faker.lorem().sentence(1, 3),
                    faker.lorem().sentence(10, 10)
            );
            messageService.save(message);
        }
    }

    public void createTasks(int amount){
        if(amount <= 0) return;
        for(int i = 0; i < amount; i++){
            Task task = new Task(
                    null,
                    faker.lorem().sentence(1, 3),
                    faker.lorem().sentence(10, 10),
                    (long) faker.number().numberBetween(0, 100)
                    //null
            );
            taskService.save(task);
        }
    }

    public void createMissions(int amount){
        String[] severities = {
                "Mild",
                "Moderate",
                "High",
                "Urgent"
        };
        String[] difficulties = {
                "Very eassy",
                "Eassy",
                "Normal",
                "Hard",
                "Very hard"
        };
        List<Task> tasks = taskService.findAll();
        if(amount <= 0) return;
        for(int i = 0; i < amount; i++){
            int randomSeverity = (int) (Math.random() * severities.length);
            int randomDifficulty = (int) (Math.random() * difficulties.length);
            Mission mission = new Mission(
                    null,
                    faker.lorem().sentence(1, 3),
                    faker.lorem().sentence(10, 10),
                    faker.lorem().sentence(1, 20),
                    severities[randomSeverity],
                    difficulties[randomDifficulty],
                    faker.lorem().sentence(2, 10),
                    false,
                    false,
                    null,
                    null,
                    null,
                    null
                    );
            missionService.save(mission);
        }
    }
    public void createFakeUsers(int amount) {
        if (amount <= 0) return;

        // One admin
        UserDtoCreate admin = new UserDtoCreate(
                "admin",
                "admin",
                "admin",
                Role.HERALD
        );
        userService.create(admin);

        // n-1 users
        for (int i = 0; i < amount-1; i++) {
            UserDtoCreate user = new UserDtoCreate(
                    faker.name().name(),
                    faker.internet().safeEmailAddress(),
                    faker.internet().password(),
                    Role.KNIGHT_RADIANT
            );
            userService.create(user);
        }
    }
}
