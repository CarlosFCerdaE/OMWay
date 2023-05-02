package com.example.omway.model.vehicle;

import com.example.omway.model.omwUser.Driver;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Car",schema = "Vehicle")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name="Car.all",query="select e from Car e")
})
public class Car {
    @Id
    private String licensePlate;

    private String color;
    private String year;
    private boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey=@ForeignKey(name="FK_driver_car_drivercif"))
    @JsonBackReference
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey=@ForeignKey(name="FK_model_car_modelid"))
    @JsonBackReference
    private Model model;
}
