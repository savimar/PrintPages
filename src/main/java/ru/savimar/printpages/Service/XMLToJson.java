package ru.savimar.printpages.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savimar.printpages.Model.Job;
import ru.savimar.printpages.Repository.JobRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class XMLToJson {

    @Autowired
    private JobRepo jobRepo;
    private ObjectMapper objectMapper = new ObjectMapper();

    private boolean createJob(Job job) {
        boolean isCreated = true;
        try {
            jobRepo.save(job);
        } catch (Exception e) {
            isCreated = false;
            e.printStackTrace();
        }
        return isCreated;
    }

    public String getJsonFromXML(List<Job> jobs) {


        for (Job job : jobs) {
            job.setJob("" + job.getId());
            job.setTime(Timestamp.valueOf(LocalDateTime.now()));

            try {
                createJob(job);
            } catch (Exception e) {
                jobs.remove(job);
                e.printStackTrace();
            }
        }
        return writeToJson(jobs);

    }

    private String writeToJson(List<Job> jobs) {
        Set<Job> set = new HashSet<>();
        Collections.sort(jobs, Job.UserComparator);

        for (int i = 0; i < jobs.size(); i++) {
            if (i >= 1) {
                if (jobs.get(i).getUserJob().equals(jobs.get(i - 1).getUserJob())) {
                    jobs.get(i).setAmount(jobs.get(i).getAmount() + jobs.get(i - 1).getAmount());
                    set.remove(jobs.get(i - 1));
                }
            }
            set.add(jobs.get(i));
        }
        ObjectNode positionNode = objectMapper.createObjectNode();
        for (Job job : set) {
            positionNode.put(job.getUserJob(), "" + job.getAmount());

        }

        return positionNode.toString();
    }


}
