package marcos.knights.radiant.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "knightRadiant")
public class KnightRadiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ideal;
    private String firstIdeal;
    private String secondIdeal;
    private String thirdIdeal;
    private String fourthIdeal;
    private String fifthIdeal;
    private Long currentMissionId;
    private Long missionsCompleted;
    @ManyToOne
    private RadiantOrder radiantOrder;
}
