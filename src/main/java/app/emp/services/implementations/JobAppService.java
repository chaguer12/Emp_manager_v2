package app.emp.services.implementations;

import app.emp.entities.JobApplication;
import app.emp.services.interfaces.JobAppServiceInterface;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JobAppService implements JobAppServiceInterface {


    @Override
    public JobApplication save(JobApplication application) {
        return null;
    }

    @Override
    public boolean update(JobApplication application) {
        return false;
    }

    @Override
    public boolean delete(JobApplication application) {
        return false;
    }
}
