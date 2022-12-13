package pl.cielicki.ZadanieRekrutacyjneUp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Strefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "strefa")
    private List<Zwierze> animalList;


    public Strefa(String name, List<Zwierze> animalList) {
        this.name = name;
        this.animalList = animalList;
    }

    public Strefa(String name) {
        this.name = name;
    }

    public Strefa() {
    }

    @Override
    public String toString() {
        return "Strefa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animalList=" + animalList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Zwierze> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Zwierze> animalList) {
        this.animalList = animalList;
    }
}
