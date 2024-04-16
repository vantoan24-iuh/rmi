package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre implements Serializable {
    @Id
    @Column(name = "genre_id",columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

}
