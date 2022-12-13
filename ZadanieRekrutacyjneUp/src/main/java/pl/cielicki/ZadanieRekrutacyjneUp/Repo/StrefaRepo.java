package pl.cielicki.ZadanieRekrutacyjneUp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cielicki.ZadanieRekrutacyjneUp.model.Strefa;

import java.util.List;

@Repository
public interface StrefaRepo extends JpaRepository<Strefa, Long > {

    @Query(nativeQuery = true, value = "SELECT * FROM STREFA")
    List<Strefa> getAll();

    @Query(nativeQuery = true, value = "SELECT * FROM STREFA WHERE id=:idd")
    List<Strefa> getAllByyId(Long idd);

    @Query(nativeQuery = true, value = "SELECT * FROM STREFA WHERE id=:idd")
    Strefa getById(Long idd);


}
