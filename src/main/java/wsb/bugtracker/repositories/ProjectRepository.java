package wsb.bugtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wsb.bugtracker.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {

    @Query(
        value = "select * from project where enabled = :enabled",
        nativeQuery = true
    )

    List<Project> findAllByEnabledNative(@Param("enabled") boolean enabled);

    List<Project> findAllByEnabled(Boolean enabled);
}
