package com.example.omway.model.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Model",schema = "Vehicle")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name="Model.all",query="select e from Model e")
})
public class Model {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    /*@OneToMany(mappedBy = "model",cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Car> modelCars;*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey=@ForeignKey(name="FK_make_model_makeid"))
    @JsonBackReference
    private Make make;
}