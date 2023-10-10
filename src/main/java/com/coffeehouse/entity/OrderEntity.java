package example.ecom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice;
    private
}
