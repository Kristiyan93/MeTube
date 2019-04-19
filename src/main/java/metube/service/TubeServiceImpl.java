package metube.service;

import metube.domein.entities.Tube;
import metube.domein.models.services.TubeServiceModel;
import metube.repository.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class TubeServiceImpl implements TubeService {
    private final TubeRepository tubeRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, UserService userService, ModelMapper modelMapper) {
        this.tubeRepository = tubeRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean uploadTube(TubeServiceModel tubeServiceModel) {
        tubeServiceModel.setUploader(this.userService.findUserByName(tubeServiceModel.getUploader().getUsername()));

        try {
            this.tubeRepository.update(this.modelMapper.map(tubeServiceModel, Tube.class));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public TubeServiceModel findTubeById(String id) {
        Tube tube = this.tubeRepository.findById(id);

        if (tube == null) {
            throw new IllegalArgumentException();
        }

        return this.modelMapper.map(tube, TubeServiceModel.class);
    }
}
