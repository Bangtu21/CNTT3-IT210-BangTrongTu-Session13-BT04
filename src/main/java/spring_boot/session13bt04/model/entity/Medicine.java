package spring_boot.session13bt04.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicines")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Long id;

    @Column(name = "medicine_name", length = 100)
    private String name;

    @Column(name = "medicine_unit")
    private String unit;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;
}
