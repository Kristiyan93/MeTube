package metube.repository;

import metube.domein.entities.User;

public interface UserRepository extends GenericRepository<User, String> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
