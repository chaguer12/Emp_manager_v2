package app.emp.dao.implementations;

import app.emp.dao.interfaces.GenericDaoInterface;
import app.emp.dao.interfaces.JobAppInterfaceDAO;
import app.emp.entities.JobApplication;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;
@ApplicationScoped
public class JobAppDAO implements JobAppInterfaceDAO {
    @Inject
    private GenericDaoInterface genericDAO;
    @Override
    public JobApplication save(JobApplication application) {
        return (JobApplication) genericDAO.save(application);
    }

    @Override
    public List<JobApplication> getEmployees() {
        return genericDAO.getAll();
    }

    @Override
    public boolean deleteJobApp(JobApplication application) {
        return genericDAO.delete(application);
    }

    @Override
    public JobApplication getJobApp(UUID id) {
        return (JobApplication) genericDAO.getByID(id);
    }

    @Override
    public boolean updateJobApp(JobApplication applicationn) {
        return genericDAO.update(applicationn);
    }
}
