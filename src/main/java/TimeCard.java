import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Tapan on 9/3/2017.
 */
public class TimeCard {

    enum EntryType {
        IN,
        OUT
    }

    ArrayList<TimeEntry> entries = new ArrayList<TimeEntry>();

    class TimeEntry {
        EntryType entryType;
        float time;
        String userName;

        public TimeEntry(EntryType entryType, float time, String userName) {
            this.entryType = entryType;
            this.time = time;
            this.userName = userName;
        }
    }

    public void enter(String username, float entryTime, float exitTime) {
        entries.add(new TimeEntry(EntryType.IN, entryTime, username));
        entries.add(new TimeEntry(EntryType.OUT, exitTime, username));
    }

    public void calculate() {
        //noinspection Since15
        entries.sort(new Comparator<TimeEntry>() {
            public int compare(TimeEntry o1, TimeEntry o2) {
                if (o1.time < o2.time) {
                    return -1;
                } else if (o1.time > o2.time) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int numberOfUsers = 0;
        for (TimeEntry entry : entries) {
            if (entry.entryType == EntryType.IN) {
                numberOfUsers++;
            } else {
                numberOfUsers--;
            }

            System.out.println(entry.time + " : " + numberOfUsers);
        }
    }
}
