package com.example.omway.model.vehicle;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;

import java.util.List;

@Entity
@Data
@Table(name="Make",schema = "Vehicle")
@AllArgsConstructor
@NoArgsConstructor
/*@NamedQueries({
        @NamedQuery(name="Make.all",query="select e from Make e")
})*/
public class Make {
    @Id
    @SequenceGenerator(name="make_seq",sequenceName = "make_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "make_seq")
    private int id;
    private String name;

   /* @OneToMany(mappedBy = "make",cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Model> makeModels;*/

}
