package app.emp.services.interfaces;

import app.emp.entities.JobApplication;

public interface JobAppServiceInterface {
    JobApplication save(JobApplication application);
    boolean update(JobApplication application);
    boolean delete(JobApplication application);

}
