package apap.tutorial.pergipergi.repository;
import org.springframework.stereotype.Repository;
import apap.tutorial.pergipergi.model.DestinasiModel;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.util.Optional;
 
@Repository
public interface DestinasiDb extends JpaRepository<DestinasiModel, Long> {
  Optional<DestinasiModel> findByNegaraDestinasi(String negaraDestinasi);
}