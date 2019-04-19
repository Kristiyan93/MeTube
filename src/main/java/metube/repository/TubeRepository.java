package metube.repository;

import metube.domein.entities.Tube;

public interface TubeRepository extends GenericRepository<Tube, String> {

    Tube update(Tube entity);
}
