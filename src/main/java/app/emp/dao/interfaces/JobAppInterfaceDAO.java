package app.emp.dao.interfaces;


import app.emp.entities.JobApplication;

import java.util.List;
import java.util.UUID;

public interface JobAppInterfaceDAO {
    JobApplication save(JobApplication application);
    List<JobApplication> getEmployees();
    boolean deleteJobApp(JobApplication application);
    JobApplication getJobApp(UUID id);
    boolean updateJobApp(JobApplication applicationn);
}
