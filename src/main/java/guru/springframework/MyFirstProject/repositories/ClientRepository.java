package guru.springframework.MyFirstProject.repositories;

import guru.springframework.MyFirstProject.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long>{
}
