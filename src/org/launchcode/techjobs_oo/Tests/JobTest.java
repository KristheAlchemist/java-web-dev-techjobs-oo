package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;


public class JobTest {

    private Job emptyJobOne, emptyJobTwo, testJobOne, testJobTwo, testJobThree;

    @Before
    public void createJobObjects() {
        emptyJobOne = new Job();
        emptyJobTwo = new Job();
        testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobThree = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, emptyJobTwo.getId() - emptyJobOne.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJobOne.getName() instanceof String && testJobOne.getName() == "Product tester");
        assertTrue(testJobOne.getEmployer() instanceof Employer && testJobOne.getEmployer().getValue() == "ACME");
        assertTrue(testJobOne.getLocation() instanceof Location && testJobOne.getLocation().getValue() == "Desert");
        assertTrue(testJobOne.getPositionType() instanceof PositionType && testJobOne.getPositionType().getValue() == "Quality control");
        assertTrue(testJobOne.getCoreCompetency() instanceof CoreCompetency && testJobOne.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJobOne.equals(testJobTwo));
    }

    @Test
    public void testToString() {

        assertTrue(testJobOne.toString().startsWith("\n"));
        assertTrue(testJobOne.toString().endsWith("\n"));

        assertEquals(testJobOne.toString(), "\n" + "ID: 3\n"
                + "Name: Product tester\n"
                + "Employer: ACME\n"
                + "Location: Desert\n"
                + "Position Type: Quality control\n"
                + "Core Competency: Persistence\n");

        assertEquals(testJobThree.toString(), "\n" + "ID: 5\n"
                + "Name: Product tester\n"
                + "Employer: Data not available\n"
                + "Location: Data not available\n"
                + "Position Type: Quality control\n"
                + "Core Competency: Persistence\n");

        assertEquals(emptyJobOne.toString(), "OOPS! This job does not seem to exist.");
    };

}