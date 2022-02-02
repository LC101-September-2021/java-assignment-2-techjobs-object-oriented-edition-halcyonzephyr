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
        Assert.assertEquals(1,test_job_ID_1.getId(),.001);
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

    @Test
    public void testToStringReturnsFormattedString(){
        Assert.assertEquals('\n',test_job_1.toString().charAt(0));
        Assert.assertEquals('\n', test_job_1.toString().charAt(test_job_1.toString().length() - 1));

        Assert.assertEquals("\nID: " + test_job_1.getId() +
                "\nName: " + test_job_1.getName() +
                "\nEmployer: " + test_job_1.getEmployer() +
                "\nLocation: " + test_job_1.getLocation() +
                "\nPosition Type: " + test_job_1.getPositionType() +
                "\nCore Competency: " + test_job_1.getCoreCompetency() + "\n", test_job_1.toString());

        Job test_job_no_name = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job_no_employer = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job_no_location = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job_no_position_type = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        Job test_job_no_core_competency = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));

         Assert.assertEquals("\nID: " + test_job_no_name.getId() +
        "\nName: " + "Data not available" +
                "\nEmployer: " + test_job_no_name.getEmployer() +
                "\nLocation: " + test_job_no_name.getLocation() +
                "\nPosition Type: " + test_job_no_name.getPositionType() +
                "\nCore Competency: " + test_job_no_name.getCoreCompetency() + "\n", test_job_no_name.toString());

        Assert.assertEquals("\nID: " + test_job_no_employer.getId() +
                "\nName: " + test_job_no_employer.getName() +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + test_job_no_employer.getLocation() +
                "\nPosition Type: " + test_job_no_employer.getPositionType() +
                "\nCore Competency: " + test_job_no_employer.getCoreCompetency() + "\n", test_job_no_employer.toString());

        Assert.assertEquals("\nID: " + test_job_no_location.getId() +
                "\nName: " + test_job_no_location.getName() +
                "\nEmployer: " + test_job_no_location.getEmployer() +
                "\nLocation: " + "Data not available" +
                "\nPosition Type: " + test_job_no_location.getPositionType() +
                "\nCore Competency: " + test_job_no_location.getCoreCompetency() + "\n", test_job_no_location.toString());

        Assert.assertEquals("\nID: " + test_job_no_position_type.getId() +
                "\nName: " + test_job_no_position_type.getName() +
                "\nEmployer: " + test_job_no_position_type.getEmployer() +
                "\nLocation: " + test_job_no_position_type.getLocation() +
                "\nPosition Type: " + "Data not available" +
                "\nCore Competency: " + test_job_no_position_type.getCoreCompetency() + "\n", test_job_no_position_type.toString());

        Assert.assertEquals("\nID: " + test_job_no_core_competency.getId() +
                "\nName: " + test_job_no_core_competency.getName() +
                "\nEmployer: " + test_job_no_core_competency.getEmployer() +
                "\nLocation: " + test_job_no_core_competency.getLocation() +
                "\nPosition Type: " + test_job_no_core_competency.getPositionType() +
                "\nCore Competency: " + "Data not available" + "\n", test_job_no_core_competency.toString());

        Assert.assertEquals("OOPS! This job does not seem to exist.", test_job_ID_1.toString());

    }
}
