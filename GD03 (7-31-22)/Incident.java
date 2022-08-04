import java.time.LocalTime;
import java.util.Date;

public class Incident {
    public String incidentNumber;
    public Date incDate;
    public Date incEnd;
    public String radioName;
    public Date dispDate;
    public Date enrtDate;
    public Date onScnDate;
    public LocalTime travelTime;
    public LocalTime responseTime;
    public String incidentType;
    public String incidentDesc;
    public int lat;
    public int lon;

    public Incident(String incidentNumber, Date incDate, Date incEnd, String radioName, Date dispDate, Date enrtDate, Date onScnDate, LocalTime travelTime, LocalTime responseTime, String incidentType, String incidentDesc, int lat, int lon) {
        this.incidentNumber = incidentNumber;
        this.incDate = incDate;
        this.incEnd = incEnd;
        this.radioName = radioName;
        this.dispDate = dispDate;
        this.enrtDate = enrtDate;
        this.onScnDate = onScnDate;
        this.travelTime = travelTime;
        this.responseTime = responseTime;
        this.incidentType = incidentType;
        this.incidentDesc = incidentDesc;
        this.lat = lat;
        this.lon = lon;
    }

    public String toString() {
        return incidentNumber + " " + incDate + " " + incEnd + " " + radioName + " " + dispDate + " " + enrtDate + " " + onScnDate +
                " " + travelTime + " " + responseTime + " " + incidentType + " " + incidentDesc + " " + lat + " " + lon;
    }
}
