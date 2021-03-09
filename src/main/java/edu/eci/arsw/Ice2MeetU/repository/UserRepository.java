package edu.eci.arsw.Ice2MeetU.repository;

import edu.eci.arsw.Ice2MeetU.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query(value = "Select * from usuarios where :name",nativeQuery = true)
    User findUserByName(@Param("name") String name);
}
