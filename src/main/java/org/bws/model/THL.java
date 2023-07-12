package org.bws.model;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "THL")
public class THL {
    @Id
    Integer id;
    String data ;
    LocalDateTime date ;

    /*public Integer getId() {
        return id;
    }
    public String getData() {
        return data;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public THL() {
    }
    public THL(Integer id, String data, LocalDateTime date) {
        this.id = id;
        this.data = data;
        this.date = date;
    }*/


}
