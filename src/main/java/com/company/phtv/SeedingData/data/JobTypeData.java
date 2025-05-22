package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.JobType;

import java.util.ArrayList;
import java.util.List;

public class JobTypeData {
    public List<JobType> Data(){
        List<JobType> data = new ArrayList<>();
        data.add(new JobType(1,"In Office"));
        data.add(new JobType(2,"Hybird"));
        data.add(new JobType(3,"Remote"));
        data.add(new JobType(4,"Oversea"));
        return data;
    }
}
