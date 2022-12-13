package pl.cielicki.ZadanieRekrutacyjneUp.GUI;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.ZwierzeRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Strefa;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Zwierze;

@Route("ShowByName")
public class ShowByName extends VerticalLayout {
    private ZwierzeRepo zwierzeRepo;

    private TextField textFieldName;

    private Grid<Zwierze> zwierzeGrid = new Grid<>(Zwierze.class);

    private Button buttonfind;

    @Autowired
    public ShowByName(ZwierzeRepo zwierzeRepo) {
        this.zwierzeRepo = zwierzeRepo;

        textFieldName = new TextField("Podaj nazwę zwierzaka:");
        buttonfind = new Button("Szukaj");

        zwierzeGrid.removeColumnByKey("id");
        zwierzeGrid.removeColumnByKey("strefa");

        zwierzeGrid.addColumn((zwierze -> zwierze.getStrefa().getName())).setHeader("Strefa");

        buttonfind.addClickListener(buttonClickEvent -> {
           zwierzeGrid.setItems(zwierzeRepo.getByName(textFieldName.getValue()));
           add(zwierzeGrid);
        });

     add(textFieldName, buttonfind);
    }
}
