package br.pucrs.ages.mase.user_service.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "volunteers")
public class Volunteer extends User {

    private @Indexed String occupation;
    private String councilNumber;
    private String institutionalLink;
    private Location lastLocation;

    public String getOccupation() {
        return occupation;
    }

    public String getCouncilNumber() {
        return councilNumber;
    }

    public String getInstitutionalLink() {
        return institutionalLink;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

}
