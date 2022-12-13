package pl.cielicki.ZadanieRekrutacyjneUp.GUI;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.StrefaRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.ZwierzeRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Strefa;

@Route("RaportFood")
public class RaportFoodGui extends VerticalLayout {
    private ZwierzeRepo zwierzeRepo;
    private StrefaRepo strefaRepo;
    private TextField textField;

    @Autowired
    public RaportFoodGui(ZwierzeRepo zwierzeRepo, StrefaRepo strefaRepo) {

        textField = new TextField();

        this.zwierzeRepo = zwierzeRepo;
        this.strefaRepo = strefaRepo;


        Long idZone = zwierzeRepo.getMaxSumFood();
        Strefa zone = strefaRepo.getById(idZone);

        textField.setReadOnly(true);
        textField.setLabel("Nazwa strefy");
        textField.setHelperText("Strefa, gdzie jest największe zapotrzebowanie na karmę");
        textField.setValue(zone.getName());
        add(textField);
    }
}
