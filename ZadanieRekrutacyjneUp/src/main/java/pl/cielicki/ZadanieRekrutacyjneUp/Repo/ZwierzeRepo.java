package pl.cielicki.ZadanieRekrutacyjneUp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Zwierze;

import java.util.List;

@Repository
public interface ZwierzeRepo extends JpaRepository<Zwierze, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ZWIERZE")
    List<Zwierze> getAll();

    @Query(nativeQuery = true, value ="SELECT * FROM ZWIERZE z WHERE z.name = :name")
    List<Zwierze> getByName(String name);

    // getMaxSumFood zwraca id strefy, w której jest największe zapotrzebowanie na karmę
    @Query(nativeQuery = true, value = "SELECT TOP 1 STREFA_ID FROM(SELECT STREFA_ID, SUM(FOOD) as score FROM ZWIERZE GROUP BY STREFA_ID) ORDER BY Score DESC")
    Long getMaxSumFood();

    // getLeast zwraca id strefy, gdzie jest najmniej zwierząt spośród wszystkich stref
    @Query(nativeQuery = true, value = "SELECT TOP 1 STREFA_ID FROM ZWIERZE GROUP BY STREFA_ID ORDER BY STREFA_ID DESC")
    Long getLeast();

}
