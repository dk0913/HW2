package model;

import java.io.Serializable;


/*PatentPublication class is a data model class that implements that Serializable interface so that
* PatentPublication objects can be passed as extras between activities*/
public class PatentPublication implements Serializable {
    /*Declares three strings that will store the id, title, and assignee of each patent*/
    private String id;
    private String title;
    private String assignee;

    /*Constructor*/
    public PatentPublication (String id, String title, String assignee){
        this.id = id;
        this.title = title;
        this.assignee = assignee;

    }

    /*Getters and setters for each field of the PatentPublication objects*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
}
