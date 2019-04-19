package metube.domein.models.views;

import java.util.List;

public class UserProfileViewModel {
    private String username;
    private String email;
    private List<UserTubeViewModel> tubes;

    private  UserProfileViewModel() { }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserTubeViewModel> getTubes() {
        return tubes;
    }

    public void setTubes(List<UserTubeViewModel> tubes) {
        this.tubes = tubes;
    }
}
