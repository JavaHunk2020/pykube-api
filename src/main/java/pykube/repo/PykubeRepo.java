package pykube.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pykube.net.PykubeModel;

public interface PykubeRepo extends JpaRepository<PykubeModel, Long>{

}
