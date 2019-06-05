package tema;
import java.time.LocalDateTime;
import java.util.*;


public class MonitoredData {
    LocalDateTime start_time;
    LocalDateTime end_time;
    String activity;
    public List<MonitoredData> monitoredData;
    public MonitoredData(LocalDateTime start_time,LocalDateTime end_time,String activity)
    {
        this.start_time=start_time;
        this.end_time=end_time;
        this.activity=activity;
    }
    public LocalDateTime start()
    {
        return start_time;
    }
    public LocalDateTime end()
    {
        return end_time;
    }
    public String Activities()
    {
        return activity;
    }



}

