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
@Table(name = "songs")
public class Song implements Serializable {
    @Id
    @Column(name = "song_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "runtime")
    private String runtime;

    @Column(name = "lyric")
    private String lyric;

    @Column(name = "file_link")
    private String fileLink;

}
