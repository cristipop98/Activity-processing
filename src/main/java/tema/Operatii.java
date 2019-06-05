package tema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDateTime;

public class Operatii {
    List<MonitoredData> activ=new ArrayList<>();
    public void create()
    {
        String file="C://Users/Cristi/Desktop/Activity.txt";
        try(Stream<String> stream= Files.lines(Paths.get(file)))
        {

            stream.forEach(line->
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime date1,date2;
                String  activity;
                String[] v = line.split("\t\t");
                date1=LocalDateTime.parse(v[0],formatter);
                date2=LocalDateTime.parse(v[1],formatter);
                activity=v[2];
                activ.add(new MonitoredData(date1, date2, activity));
            });

        }catch(IOException e)
        {
            System.out.println("Eroare");
        }

    }
    public void afisare()
    {
        System.out.println("Start_time\t\t\t End_time\t\t\t Activity");
        activ.forEach(md->System.out.println(md.start()+" "+md.end()+" "+md.Activities()));
    }
    public void afisare2()
    {
        activ.forEach(md->System.out.println(ChronoUnit.SECONDS.between(md.start(), md.end())));
    }
    public void nrZile()
    {
        long result = activ.stream().map(e->e.start().toLocalDate()).distinct()
                .collect(Collectors.counting());
        System.out.println("Nr de zile:"+result);
    }
    public void distinctActivities()
    {
        Map<String,Long> activities=activ.stream().collect(Collectors.groupingBy(p->p.Activities(),Collectors.counting()));
        try{
            for(String key:activities.keySet())
            {
                System.out.println(key+" "+activities.get(key).intValue());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }






}