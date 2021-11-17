package apap.tutorial.pergipergi.repository;

import apap.tutorial.pergipergi.model.RoleModel;
import apap.tutorial.pergipergi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long> {

}
