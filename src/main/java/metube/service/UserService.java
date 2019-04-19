package metube.service;

import metube.domein.models.services.UserServiceModel;

public interface UserService {

    boolean registerUser(UserServiceModel userServiceModel);

    boolean loginUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByName(String username);

}
