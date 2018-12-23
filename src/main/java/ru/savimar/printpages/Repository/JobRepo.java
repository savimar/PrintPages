package ru.savimar.printpages.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.savimar.printpages.Model.Job;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface JobRepo extends CrudRepository<Job, Integer> {

    List<Job> findAllByType(String type);

    List<Job> findAllByUserJob(String userJob);

    List<Job> findAllByDevice(String device);

    List<Job> findAllByTimeAfter(Timestamp timeFrom);

    List<Job> findAllByTimeBefore(Timestamp timeTo);

    List<Job> findAllByTimeBetween(Timestamp timeFrom, Timestamp timeTo);

    List<Job> findAllByTypeAndUserJob(String type, String userJob);

    List<Job> findAllByTypeAndDevice(String type, String device);

    List<Job> findAllByTypeAndTimeAfter(String type, Timestamp timeFrom);

    List<Job> findAllByTypeAndTimeBefore(String type, Timestamp timeTo);

    List<Job> findAllByTypeAndTimeBetween(String type, Timestamp timeFrom, Timestamp timeTo);

    List<Job> findAllByUserJobAndDevice(String userJob, String device);

    List<Job> findAllByUserJobAndTimeAfter(String userJob, Timestamp timeFrom);

    List<Job> findAllByUserJobAndTimeBefore(String userJob, Timestamp timeTo);

    List<Job> findAllByUserJobAndTimeBetween(String userJob, Timestamp timeFrom, Timestamp timeTo);

    List<Job> findAllByDeviceAndTimeAfter(String device, Timestamp timeFrom);

    List<Job> findAllByDeviceAndTimeBefore(String device, Timestamp timeTo);

    List<Job> findAllByDeviceAndTimeBetween(String device, Timestamp timeFrom, Timestamp timeTo);

    List<Job> findAllByTypeAndUserJobAndDevice(String type, String userJob, String device);

    List<Job> findAllByTypeAndUserJobAndTimeAfter(String type, String userJob, Timestamp timeFrom);

    List<Job> findAllByTypeAndUserJobAndTimeBefore(String type, String userJob, Timestamp timeTo);

    List<Job> findAllByTypeAndUserJobAndTimeBetween(String type, String userJob, Timestamp timeFrom, Timestamp timeTo);

    List<Job> findAllByTypeAndDeviceAndTimeAfter(String type, String device, Timestamp timeFrom);

    List<Job> findAllByTypeAndDeviceAndTimeBefore(String type, String device, Timestamp timeTo);

    List<Job> findAllByTypeAndDeviceAndTimeBetween(String type, String device, Timestamp timeFrom, Timestamp timeTo);

    List<Job> findAllByUserJobAndDeviceAndTimeAfter(String userJob, String device, Timestamp timeFrom);

    List<Job> findAllByUserJobAndDeviceAndTimeBefore(String userJob, String device, Timestamp timeTo);

    List<Job> findAllByUserJobAndDeviceAndTimeBetween(String userJob, String device, Timestamp timeFrom, Timestamp timeTo);

    List<Job> findAllByTypeAndUserJobAndDeviceAndTimeAfter(String type, String userJob, String device, Timestamp timeFrom);

    List<Job> findAllByTypeAndUserJobAndDeviceAndTimeBefore(String type, String userJob, String device, Timestamp timeTo);

    List<Job> findAllByTypeAndUserJobAndDeviceAndTimeBetween(String type, String userJob, String device, Timestamp timeFrom, Timestamp timeTo);


}
