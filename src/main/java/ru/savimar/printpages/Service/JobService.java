package ru.savimar.printpages.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savimar.printpages.Model.Job;
import ru.savimar.printpages.Model.JobJson;
import ru.savimar.printpages.Repository.JobRepo;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;
    private ObjectMapper objectMapper = new ObjectMapper();


    private List<Job> findAllByType(String type) {
        return jobRepo.findAllByType(type);
    }

    private List<Job> findAllByUserJob(String userJob) {
        return jobRepo.findAllByUserJob(userJob);
    }

    private List<Job> findAllByDevice(String device) {
        return jobRepo.findAllByDevice(device);
    }

    private List<Job> findAllByTimeAfter(Timestamp timeFrom) {
        return jobRepo.findAllByTimeAfter(timeFrom);
    }

    private List<Job> findAllByTimeBefore(Timestamp timeTo) {
        return jobRepo.findAllByTimeBefore(timeTo);
    }

    private List<Job> findAllByTimeBetween(Timestamp timeFrom, Timestamp timeTo) {
        return jobRepo.findAllByTimeBetween(timeFrom, timeTo);
    }

    private List<Job> findAllByTypeAndUserJob(String type, String userJob) {
        return jobRepo.findAllByTypeAndUserJob(type, userJob);
    }

    private List<Job> findAllByTypeAndDevice(String type, String device) {
        return jobRepo.findAllByTypeAndDevice(type, device);
    }

    private List<Job> findAllByTypeAndTimeAfter(String type, Timestamp timeFrom) {
        return jobRepo.findAllByTypeAndTimeAfter(type, timeFrom);
    }

    private List<Job> findAllByTypeAndTimeBefore(String type, Timestamp timeTo) {
        return jobRepo.findAllByTypeAndTimeBefore(type, timeTo);
    }

    private List<Job> findAllByTypeAndTimeBetween(String type, Timestamp timeFrom, Timestamp timeTo) {
        return jobRepo.findAllByTypeAndTimeBetween(type, timeFrom, timeTo);
    }

    private List<Job> findAllByUserJobAndDevice(String userJob, String device) {
        return jobRepo.findAllByUserJobAndDevice(userJob, device);
    }

    private List<Job> findAllByUserJobAndTimeAfter(String userJob, Timestamp timeFrom) {
        return jobRepo.findAllByUserJobAndTimeAfter(userJob, timeFrom);
    }

    private List<Job> findAllByUserJobAndTimeBefore(String userJob, Timestamp timeTo) {
        return jobRepo.findAllByUserJobAndTimeBefore(userJob, timeTo);
    }

    private List<Job> findAllByUserJobAndTimeBetween(String userJob, Timestamp timeFrom, Timestamp timeTo) {
        return jobRepo.findAllByUserJobAndTimeBetween(userJob, timeFrom, timeTo);
    }

    private List<Job> findAllByDeviceAndTimeAfter(String device, Timestamp timeFrom) {
        return jobRepo.findAllByDeviceAndTimeAfter(device, timeFrom);
    }

    private List<Job> findAllByDeviceAndTimeBefore(String device, Timestamp timeTo) {
        return jobRepo.findAllByDeviceAndTimeBefore(device, timeTo);
    }

    private List<Job> findAllByDeviceAndTimeBetween(String device, Timestamp timeFrom, Timestamp timeTo) {
        return jobRepo.findAllByDeviceAndTimeBetween(device, timeFrom, timeTo);
    }

    private List<Job> findAllByTypeAndUserJobAndDevice(String type, String userJob, String device) {
        return jobRepo.findAllByTypeAndUserJobAndDevice(type, userJob, device);
    }

    private List<Job> findAllByTypeAndUserJobAndTimeAfter(String type, String userJob, Timestamp timeFrom) {
        return jobRepo.findAllByTypeAndUserJobAndTimeAfter(type, userJob, timeFrom);
    }

    private List<Job> findAllByTypeAndUserJobAndTimeBefore(String type, String userJob, Timestamp timeTo) {
        return jobRepo.findAllByTypeAndUserJobAndTimeBefore(type, userJob, timeTo);
    }

    private List<Job> findAllByTypeAndUserJobAndTimeBetween(String type, String userJob, Timestamp timeFrom, Timestamp timeTo) {
        return jobRepo.findAllByTypeAndUserJobAndTimeBetween(type, userJob, timeFrom, timeTo);
    }

    private List<Job> findAllByTypeAndDeviceAndTimeAfter(String type, String device, Timestamp timeFrom) {
        return jobRepo.findAllByTypeAndDeviceAndTimeAfter(type, device, timeFrom);
    }

    private List<Job> findAllByTypeAndDeviceAndTimeBefore(String type, String device, Timestamp timeTo) {
        return jobRepo.findAllByTypeAndDeviceAndTimeBefore(type, device, timeTo);
    }

    private List<Job> findAllByTypeAndDeviceAndTimeBetween(String type, String device, Timestamp timeFrom, Timestamp timeTo) {
        return jobRepo.findAllByTypeAndDeviceAndTimeBetween(type, device, timeFrom, timeTo);
    }

    private List<Job> findAllByUserJobAndDeviceAndTimeAfter(String userJob, String device, Timestamp timeFrom) {
        return jobRepo.findAllByUserJobAndDeviceAndTimeAfter(userJob, device, timeFrom);
    }

    private List<Job> findAllByUserJobAndDeviceAndTimeBefore(String userJob, String device, Timestamp timeTo) {
        return jobRepo.findAllByUserJobAndDeviceAndTimeBefore(userJob, device, timeTo);
    }

    private List<Job> findAllByUserJobAndDeviceAndTimeBetween(String userJob, String device, Timestamp timeFrom, Timestamp timeTo) {
        return jobRepo.findAllByUserJobAndDeviceAndTimeBetween(userJob, device, timeFrom, timeTo);
    }

    private List<Job> findAllByTypeAndUserJobAndDeviceAndTimeAfter(String type, String userJob, String device, Timestamp timeFrom) {
        return jobRepo.findAllByTypeAndUserJobAndDeviceAndTimeAfter(type, userJob, device, timeFrom);
    }

    private List<Job> findAllByTypeAndUserJobAndDeviceAndTimeBefore(String type, String userJob, String device, Timestamp timeTo) {
        return jobRepo.findAllByTypeAndUserJobAndDeviceAndTimeBefore(type, userJob, device, timeTo);
    }

    private List<Job> findAllByTypeAndUserJobAndDeviceAndTimeBetween(String type, String userJob, String device, Timestamp timeFrom, Timestamp timeTo) {
        return jobRepo.findAllByTypeAndUserJobAndDeviceAndTimeBetween(type, userJob, device, timeFrom, timeTo);
    }

    public String getStatistics(String type, String userJob, String device, Timestamp timeFrom, Timestamp timeTo) {

        List<Job> jobList = new ArrayList<>();
        if (type != null && userJob == null && device == null && timeFrom == null && timeTo == null) {
            jobList = findAllByType(type);
        } else if (type == null && userJob != null && device == null && timeFrom == null && timeTo == null) {
            jobList = findAllByUserJob(userJob);
        } else if (type == null && userJob == null && device != null && timeFrom == null && timeTo == null) {
            jobList = findAllByDevice(device);
        } else if (type == null && userJob == null && device == null && timeFrom != null && timeTo == null) {
            jobList = findAllByTimeAfter(timeFrom);
        } else if (type == null && userJob == null && device == null && timeFrom == null && timeTo != null) {
            jobList = findAllByTimeBefore(timeTo);
        } else if (type != null && userJob != null && device == null && timeFrom == null && timeTo == null) {
            jobList = findAllByTypeAndUserJob(type, userJob);
        } else if (type != null && userJob == null && device != null && timeFrom == null && timeTo == null) {
            jobList = findAllByTypeAndDevice(type, device);
        } else if (type != null && userJob != null && device == null && timeFrom != null && timeTo == null) {
            jobList = findAllByTypeAndUserJobAndTimeAfter(type, userJob, timeFrom);
        } else if (type != null && userJob != null && device == null && timeFrom == null && timeTo != null) {
            jobList = findAllByTypeAndUserJobAndTimeBefore(type, userJob, timeTo);
        } else if (type != null && userJob != null && device == null && timeFrom != null && timeTo != null) {
            jobList = findAllByTypeAndUserJobAndTimeBetween(type, userJob, timeFrom, timeTo);
        } else if (type == null && userJob != null && device != null && timeFrom == null && timeTo == null) {
            jobList = findAllByUserJobAndDevice(userJob, device);
        } else if (type == null && userJob != null && device != null && timeFrom != null && timeTo == null) {
            jobList = findAllByUserJobAndDeviceAndTimeAfter(userJob, device, timeFrom);
        } else if (type == null && userJob != null && device != null && timeFrom == null && timeTo != null) {
            jobList = findAllByUserJobAndDeviceAndTimeBefore(userJob, device, timeTo);
        } else if (type == null && userJob != null && device != null && timeFrom != null && timeTo != null) {
            jobList = findAllByUserJobAndDeviceAndTimeBetween(userJob, device, timeFrom, timeTo);
        } else if (type != null && userJob != null && device != null && timeFrom == null && timeTo == null) {
            jobList = findAllByTypeAndUserJobAndDevice(type, userJob, device);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
        List<JobJson> jobJsons = new ArrayList<>();
        Collections.sort(jobList);
        for (Job job : jobList) {
            JobJson jobJson = new JobJson(job.getId(), job.getDevice(), job.getUserJob(), job.getType(), job.getAmount(), job.getTime().toLocalDateTime().format(formatter));
            jobJsons.add(jobJson);
        }
        return writeResultResponseToJson(jobJsons);

    }


    private String writeResultResponseToJson(List<JobJson> jobs) {

        String jsonInString = null;
        try {
            jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jobs);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
}
