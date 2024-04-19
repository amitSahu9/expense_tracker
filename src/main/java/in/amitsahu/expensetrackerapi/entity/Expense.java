package in.amitsahu.expensetrackerapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_name")
    @NotBlank(message = "Expense name must not be null!")
    @Size(min = 3, message = "Expense name must be of minimum 3 characters")
    private String name;

    private String description;

    @Column(name = "expense_amount")
    @NotNull(message = "expense amount should not be null!")
    private BigDecimal amount;

    @NotBlank(message = "category should not be null!")
    private String category;

    @NotNull(message = "date must not be null!")
    private Date date;

    @Column(name = "created_ts", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp created_ts;

    @Column(name = "updated_ts")
    @UpdateTimestamp
    private Timestamp updated_ts;
}
