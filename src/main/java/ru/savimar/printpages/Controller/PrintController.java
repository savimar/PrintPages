package ru.savimar.printpages.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.savimar.printpages.Model.Job;
import ru.savimar.printpages.Model.Jobs;
import ru.savimar.printpages.Service.JobService;
import ru.savimar.printpages.Service.XMLToJson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PrintController {
    @Autowired
    XMLToJson xmlToJson;
    @Autowired
    JobService jobService;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET, produces = "application/json")
    public String getStatistics(@RequestParam(value = "user", required = false) String userJob,
                                @RequestParam(value = "type", required = false) String type,
                                @RequestParam(value = "device", required = false) String device,
                                @RequestParam(value = "timeFrom", required = false) String timeFrom,
                                @RequestParam(value = "timeTo", required = false) String timeTo) {

        Timestamp timestampFrom = null;
        Timestamp timestampTo = null;

        timestampFrom = getTimestamp(timeFrom, timestampFrom);
        timestampTo = getTimestamp(timeTo, timestampTo);


        return jobService.getStatistics(type, userJob, device, timestampFrom, timestampTo);
    }

    private Timestamp getTimestamp(String timeFrom, Timestamp timestampFrom) {
        if (timeFrom != null) {
            try {
                timestampFrom = Timestamp.valueOf(timeFrom);
            } catch (Exception e) {
                timestampFrom = Timestamp.valueOf(LocalDateTime.parse(timeFrom));
                e.printStackTrace();
            }

        }
        return timestampFrom;
    }

    @RequestMapping("/job")
    public String index() {
        List<Job> jobs = getJobs();
        return xmlToJson.getJsonFromXML(jobs);
    }

    private List<Job> getJobs() {
        List<Job> list = null;
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\printpages\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Jobs.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Jobs jobs = (Jobs) jaxbUnmarshaller.unmarshal(file);
            list = jobs.getJobs();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

