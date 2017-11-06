package com.afy.cheaper.data;

/**
 * Created by isayed on 10/29/2017.
 */
/*import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
*/
public class Offer {
    int id;
    String description;
    String status;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String topString() {
        return "Id="+getId()+", Name="+getName()+ ", Status ="+getStatus()+", desc = "+getDescription();
    }
}
