package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {

        String dataNotAvailable = "Data not available";
        String jobDoesNotExist = "OOPS! This job does not seem to exist.";
        String nameValue;

        try {
            if (
                    (name == null || name.isEmpty()) &&
                    (employer.getValue() == null || employer.getValue().isEmpty()) &&
                    (location.getValue() == null || location.getValue().isEmpty()) &&
                    (positionType.getValue() == null || positionType.getValue().isEmpty()) &&
                    (coreCompetency.getValue() == null || coreCompetency.getValue().isEmpty())
            ) {
                return jobDoesNotExist;
            }
        } catch (NullPointerException npe) {
            return jobDoesNotExist;
        }

        if (name == null || name.isEmpty()) {
            nameValue = dataNotAvailable;
        } else {
            nameValue = name;
        }

        if (employer.getValue() == null || employer.getValue().isEmpty()) {
            employer.setValue(dataNotAvailable);
        }
        if (location.getValue() == null || location.getValue().isEmpty()) {
            location.setValue(dataNotAvailable);
        }
        if (positionType.getValue() == null || positionType.getValue().isEmpty()) {
            positionType.setValue(dataNotAvailable);
        }
        if (coreCompetency.getValue() == null || coreCompetency.getValue().isEmpty()) {
            coreCompetency.setValue(dataNotAvailable);
        }

        return "\nID: " + id +
                "\nName: " + nameValue +
                "\nEmployer: " + employer +
                "\nLocation: " + location +
                "\nPosition Type: " + positionType +
                "\nCore Competency: " + coreCompetency + "\n";
    }
    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
