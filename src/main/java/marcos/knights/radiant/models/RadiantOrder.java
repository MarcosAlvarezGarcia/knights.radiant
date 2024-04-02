package marcos.knights.radiant.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "radiantOrders")
public class RadiantOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String herald;
    private String archetype;
    private String gemstone;
    private String sprenType;
    private String attributes;
    private String color;
    @Column(columnDefinition = "LONGTEXT")
    private String oathTheme;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @ManyToMany
    private List<Surge> surges;
}
