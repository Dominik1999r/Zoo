package pl.cielicki.ZadanieRekrutacyjneUp.model;

import javax.persistence.*;

@Entity
public class Zwierze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int food;
    private Animal animal;
    @ManyToOne()
    private Strefa strefa;

    public Zwierze() {
    }

    public Zwierze(String name, int food, Animal animal, Strefa strefa) {
        this.name = name;
        this.food = food;
        this.animal = animal;
        this.strefa = strefa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Strefa getStrefa() {
        return strefa;
    }

    public void setStrefa(Strefa strefa) {
        this.strefa = strefa;
    }

}
