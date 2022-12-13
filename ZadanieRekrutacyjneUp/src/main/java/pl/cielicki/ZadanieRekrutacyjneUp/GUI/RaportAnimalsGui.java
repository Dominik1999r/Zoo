package pl.cielicki.ZadanieRekrutacyjneUp.GUI;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.StrefaRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.ZwierzeRepo;

@Route("/RaportAnimals")
public class RaportAnimalsGui extends VerticalLayout {
    private ZwierzeRepo zwierzeRepo;
    private StrefaRepo strefaRepo;
    private TextField textField;

    @Autowired
    public RaportAnimalsGui(ZwierzeRepo zwierzeRepo, StrefaRepo strefaRepo) {

        this.zwierzeRepo = zwierzeRepo;
        this.strefaRepo = strefaRepo;

        textField = new TextField();

        textField.setReadOnly(true);
        textField.setLabel("Nazwa strefy");
        textField.setHelperText("Strefa, gdzie jest najmniej zwierząt spośród innych stref. Nie uwzględnia się stref, gdzie nia ma żadnego zwierzęcia!");
        textField.setValue(strefaRepo.getById(zwierzeRepo.getLeast()).getName());
        add(textField);
    }
}
