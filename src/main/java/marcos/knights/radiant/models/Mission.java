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
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany
    private List<Task> tasks;
    @OneToMany
    private List<Message> messages;
    private String severity;
    private String difficulty;
    private String estimatedTime;
    private Boolean active;
    private Boolean done;
}
