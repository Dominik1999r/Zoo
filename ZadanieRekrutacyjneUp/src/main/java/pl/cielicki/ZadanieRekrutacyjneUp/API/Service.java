package pl.cielicki.ZadanieRekrutacyjneUp.API;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.StrefaRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.Repo.ZwierzeRepo;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Animal;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Strefa;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Zwierze;

@Component
public class Service {
    @Autowired
    private StrefaRepo strefaRepo;
    @Autowired
    private ZwierzeRepo zwierzeRepo;

    @EventListener(ApplicationReadyEvent.class)

    // wczytuje do bazy przykładowe dane
    public void runExample(){

        Strefa strefa0 = new Strefa("Danger-zone");
        Strefa strefa1 = new Strefa("Africa");
        Strefa strefa2 = new Strefa("Australia");
        Strefa strefa3 = new Strefa("Orientatium");

        Zwierze zwierze1 = new Zwierze("Lew-1", 11, Animal.SSAKI, strefa0);
        Zwierze zwierze2 = new Zwierze("Slon-1", 20, Animal.SSAKI, strefa3);
        Zwierze zwierze3 = new Zwierze("Królik", 4, Animal.SSAKI, strefa1);


        strefaRepo.save(strefa0);
        strefaRepo.save(strefa1);
        strefaRepo.save(strefa2);
        strefaRepo.save(strefa3);

        zwierzeRepo.save(zwierze1);
        zwierzeRepo.save(zwierze2);
        zwierzeRepo.save(zwierze3);

    }
}
