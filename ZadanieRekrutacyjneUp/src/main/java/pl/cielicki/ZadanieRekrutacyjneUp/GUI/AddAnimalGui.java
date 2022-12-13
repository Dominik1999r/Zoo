package pl.cielicki.ZadanieRekrutacyjneUp.GUI;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.StrefaRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.ZwierzeRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Animal;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Strefa;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Zwierze;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Route("/AddAnimal")
@PersistenceContext(type = PersistenceContextType.EXTENDED)
public class AddAnimalGui extends VerticalLayout {

    private StrefaRepo strefaRepo;
    private ZwierzeRepo zwierzeRepo;

    private TextField textFieldValueOfFood;
    private TextField textFieldNameZwierze;
    private TextField textFieldIdStrefy;
    private Button buttonAddZwierze;
    private ComboBox<Animal> comboBoxAnimalType;
    private Grid<Strefa> gridStrefa = new Grid<>(Strefa.class);

    @Autowired
    public AddAnimalGui(StrefaRepo strefaRepo, ZwierzeRepo zwierzeRepo) {
        this.strefaRepo = strefaRepo;
        this.zwierzeRepo = zwierzeRepo;

        textFieldNameZwierze = new TextField("Nazwa zwierzecia:");
        textFieldValueOfFood = new TextField("Ilosc potrzebnego jedzenia");
        textFieldIdStrefy = new TextField("Wybierz id Strefy");
        comboBoxAnimalType = new ComboBox<>("Animal typ", Animal.values());
        buttonAddZwierze = new Button("Add Zwierze");

        gridStrefa.setItems(strefaRepo.getAll());
        gridStrefa.removeColumnByKey("animalList");

       buttonAddZwierze.addClickListener(buttonClickEvent -> {
          Zwierze zwierze = new Zwierze();
          zwierze.setName(textFieldNameZwierze.getValue());
          zwierze.setFood(Integer.parseInt(textFieldValueOfFood.getValue()));
          zwierze.setAnimal(comboBoxAnimalType.getValue());
          List<Strefa> strefaList = strefaRepo.getAllByyId(Long.valueOf(textFieldIdStrefy.getValue()));
          Strefa strefa = strefaList.get(0);
          zwierze.setStrefa(strefa);

          zwierzeRepo.save(zwierze);

           Notification notification = new Notification("Zwierze dodane!", 3000);
           notification.open();
       });


        add(textFieldNameZwierze);
        add(textFieldValueOfFood);
        add(gridStrefa);
        add(textFieldIdStrefy);
        add(comboBoxAnimalType);
        add(buttonAddZwierze);
    }
}
