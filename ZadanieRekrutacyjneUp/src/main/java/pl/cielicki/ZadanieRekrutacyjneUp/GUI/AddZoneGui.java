package pl.cielicki.ZadanieRekrutacyjneUp.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.StrefaRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.ZwierzeRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Strefa;

@Route( "/AddZone")
public class AddZoneGui extends VerticalLayout {

    private StrefaRepo strefaRepo;
    private TextField textFieldNameStrefa;
    private Button buttonAdd;

    @Autowired
    public AddZoneGui(StrefaRepo strefaRepo, ZwierzeRepo zwierzeRepo) {
        this.strefaRepo = strefaRepo;

        textFieldNameStrefa = new TextField("Podaj nazwe strefy: ");
        buttonAdd = new Button("Dodaj strefe");

        buttonAdd.addClickListener(buttonClickEvent -> {
            strefaRepo.save(new Strefa(textFieldNameStrefa.getValue()));
            Notification notification = new Notification("Strefa dodana!", 3000);
            notification.open();
        });

        add(textFieldNameStrefa);
        add(buttonAdd);
    }
}
