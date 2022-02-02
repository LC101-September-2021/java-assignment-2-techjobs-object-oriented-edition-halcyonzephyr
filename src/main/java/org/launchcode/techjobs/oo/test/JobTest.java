package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job test_job_ID_1;
    Job test_job_ID_2;
    Job test_job_1;
    Job test_job_2;

    @Before
    public void createJobObjects(){
        test_job_ID_1 = new Job();
        test_job_ID_2 = new Job();
        test_job_1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job_2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId() {
        Assert.assertEquals(test_job_ID_1.getId(),1,.001);
        Assert.assertNotEquals(test_job_ID_1.getId(), test_job_ID_2.getId());
        Assert.assertEquals(test_job_ID_1.getId() + 1, test_job_ID_2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Assert.assertEquals(test_job_1.getId(),3,.001);
        Assert.assertTrue(test_job_1.getName() instanceof String);
        Assert.assertTrue(test_job_1.getEmployer() instanceof Employer);
        Assert.assertTrue(test_job_1.getLocation() instanceof Location);
        Assert.assertTrue(test_job_1.getPositionType() instanceof PositionType);
        Assert.assertTrue(test_job_1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Assert.assertNotEquals(test_job_1, test_job_2);
    }


}
