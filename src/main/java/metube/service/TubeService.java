package metube.service;

import metube.domein.models.services.TubeServiceModel;

public interface TubeService {

    boolean uploadTube(TubeServiceModel tubeServiceModel);

    TubeServiceModel findTubeById(String id);

}
