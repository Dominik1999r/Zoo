package pl.cielicki.ZadanieRekrutacyjneUp.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.StrefaRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.ZwierzeRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Zwierze;

import java.util.List;
import java.util.stream.Collectors;

@Route("/GetAnimals")
public class GetAnimalsGui extends VerticalLayout {

    private TextField textFieldIdStrefy;
    private Button button;
    private StrefaRepo strefaRepo;
    private ZwierzeRepo zwierzeRepo;

    private Grid<Zwierze> gridZwierze = new Grid<>(Zwierze.class);

    @Autowired
    public GetAnimalsGui(StrefaRepo strefaRepo, ZwierzeRepo zwierzeRepo) {
        this.strefaRepo = strefaRepo;
        this.zwierzeRepo = zwierzeRepo;

        TextField textField = new TextField();
        textField.setReadOnly(true);
        textField.setValue("Opis zakładki");
        textField.setHelperText("Po wpisaniu ID strefy - zostanie wypisana lista zwierząt należących do podanej strefy.");
        add(textField);

        textFieldIdStrefy = new TextField("Id strefy: ");
        button = new Button("Pokaz zwierzeta danej strefy");

        gridZwierze.removeColumnByKey("strefa");
        gridZwierze.removeColumnByKey("id");

        gridZwierze.addColumn(zwierze -> zwierze.getStrefa().getName()).setHeader("strefa");

        button.addClickListener(buttonClickEvent -> {

            List<Zwierze> zwierzeList = zwierzeRepo.getAll();
            List<Zwierze> collect = zwierzeList.stream()
                    .filter(zwierze -> zwierze.getStrefa().getId() == Integer.parseInt(textFieldIdStrefy.getValue()))
                    .collect(Collectors.toList());

           gridZwierze.setItems(collect);

           gridZwierze.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
           add(gridZwierze);
        });

        add(textFieldIdStrefy, button);
    }
}
