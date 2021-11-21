package com.share4happy.webservice_async.model;
import java.util.ArrayList;
import java.util.List;

public class ModelCommon {
    private ArrayList<Location> locations=new ArrayList<>();
    private ArrayList<OverviewInfo> overview=new ArrayList<>();
    private Today today;
    private Total total;

    public List<Location> getLocations() {
        return locations;
    }
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }
    public ArrayList<OverviewInfo> getOverview() {
        return overview;
    }
    public void setOverview(ArrayList<OverviewInfo> overview) {
        this.overview = overview;
    }
    public Today getToday() {
        return today;
    }
    public void setToday(Today today) {
        this.today = today;
    }
    public Total getTotal() {
        return total;
    }
    public void setTotal(Total total) {
        this.total = total;
    }
}
