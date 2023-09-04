package timesheet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Timesheet {
	
	private Map<Integer, Holiday> holidays = new HashMap<>();
	private Map<String, Project> projects = new HashMap<>();
	private Map<String, Activity> activities = new HashMap<>();
	private int idProfile = 0;
	private Map<String, Profile> profiles = new HashMap<>();
	private int idWorker = 0;
	private Map<String, Worker> workers = new HashMap<>();

	// R1
	public void setHolidays(int... holidays) {		
		for(int holiday: holidays) {
			if(holiday>=1 && holiday<=365 && this.holidays.containsKey(holiday)==false) {
				Holiday h = new Holiday(holiday);
				this.holidays.put(holiday, h);
				if(holiday==1) {
					this.holidays.get(1).setWeekDay(1);

					for(Holiday hd: this.holidays.values()) {
						int d = (hd.getDay()-1)%7 + 1;
						hd.setWeekDay(d);
					}
				}
			}
			
		}
		
	}
	
	public boolean isHoliday(int day) {
		return holidays.containsKey(day);
	}
	
	public void setFirstWeekDay(int weekDay) throws TimesheetException {
		if(weekDay<0 || weekDay>6) throw new TimesheetException();
		
		holidays.get(1).setWeekDay(weekDay);

		for(Holiday holiday: holidays.values()) {
			int d = ((holiday.getDay()-1)%7 + weekDay)%7;
			holiday.setWeekDay(d);
		}
		
	}
	
	public int getWeekDay(int day) throws TimesheetException {
		if(day<=0) throw new TimesheetException();
		
		return holidays.get(day).getWeekDay();
	}
	
	// R2
	public void createProject(String projectName, int maxHours) throws TimesheetException {
		
		if(maxHours<0) throw new TimesheetException();
		
		if(projects.containsKey(projectName)==false) {
			Project project = new Project(projectName, maxHours);
			projects.put(projectName, project);
		}else {
			projects.get(projectName).setMaxHours(maxHours);
		}
		
	}
	
	public List<String> getProjects() {
        return projects.values().stream()
        		.map(Project::toString)
        		.sorted((str1, str2) -> {
                    String[] parts1 = str1.split(": ");
                    String[] parts2 = str2.split(": ");
                    
                    int value1 = Integer.parseInt(parts1[1]);
                    int value2 = Integer.parseInt(parts2[1]);

                    if (value1 != value2) {
                        return Integer.compare(value2, value1); // Sort by value in discending order
                    }
                    return parts1[0].compareTo(parts2[0]); // If values are equal, sort by name in alphabetical order
                })
        		.collect(Collectors.toList());
	}
	
	public void createActivity(String projectName, String activityName) throws TimesheetException {
		
		if(projects.containsKey(projectName)==false) throw new TimesheetException();
		
		Activity activity = new Activity(projects.get(projectName), activityName);
		activities.put(activityName, activity);
		projects.get(projectName).newActivity(activity);
		
	}
	
	public void closeActivity(String projectName, String activityName) throws TimesheetException {
		
		if(projects.containsKey(projectName)==false) throw new TimesheetException();
		if(activities.containsKey(activityName)==false) throw new TimesheetException();
		
		activities.get(activityName).setCompleted(true);
	
	}
	
	public List<String> getOpenActivities(String projectName) throws TimesheetException {
		
		if(projects.containsKey(projectName)==false) throw new TimesheetException();

        return projects.get(projectName).getActivities().stream().filter(a->!a.isCompleted()).sorted(Comparator.comparing(Activity::getName)).map(Activity::getName).collect(Collectors.toList());
	}

	// R3
	public String createProfile(int... workHours) throws TimesheetException {
		
		if(workHours.length!=7) throw new TimesheetException();
		
		Profile profile = new Profile(""+idProfile);
		
		for(int workHour: workHours) {
			profile.newWorkHour(workHour);
		}
		
		profiles.put(""+idProfile, profile);
		
        return ""+idProfile++;
	}
	
	public String getProfile(String profileID) throws TimesheetException {
		
		if(profiles.containsKey(profileID)==false) throw new TimesheetException();
		
        return profiles.get(profileID).toString();
	}
	
	public String createWorker(String name, String surname, String profileID) throws TimesheetException {
		
		if(profiles.containsKey(profileID)==false) throw new TimesheetException();

		Worker worker = new Worker(name, surname, profiles.get(profileID), ""+idWorker);
		
		workers.put(""+idWorker, worker);
		
		return "" + idWorker++;
	
	}
	
	public String getWorker(String workerID) throws TimesheetException {
        return workers.get(workerID).toString();
	}
	
	// R4
	public void addReport(String workerID, String projectName, String activityName, int day, int workedHours) throws TimesheetException {
	
		if(workers.containsKey(workerID)==false) throw new TimesheetException();
		if(day<0 || this.isHoliday(day)==true) throw new TimesheetException();
		if(workedHours<0) throw new TimesheetException();
		if(workers.get(workerID).isCompatibleEntry( ((day-1)%7 + holidays.get(1).getWeekDay())%7, workedHours)==false) throw new TimesheetException();
		if(projects.containsKey(projectName)==false) throw new TimesheetException();
		if(activities.containsKey(activityName)==false) throw new TimesheetException();
		
		Worker worker = workers.get(workerID);
		Profile profile = worker.getProfile();
		
		int weekDay = getWeekDay(day);
		int maxHoursPerDay = profile.getWorkHours(weekDay);
		int oldWorkedHours = getWorkedHoursPerDay(worker, day);
		
		if (oldWorkedHours + workedHours > maxHoursPerDay) {
			throw new TimesheetException("Cannot work more than " + maxHoursPerDay + " hours");
		}

		if(activities.get(activityName).isCompleted()) throw new TimesheetException();
		
		Project project = projects.get(projectName);
		
		int maxHoursPerProject = project.getMaxHours();
		int oldProjectHours = getProjectHours(project);
		
		if (oldProjectHours + workedHours > maxHoursPerProject) {
			throw new TimesheetException("Too many hours on the project");
		}
	
		Report report = new Report(workers.get(workerID), projects.get(projectName), activities.get(activityName), day, workedHours);
		
	}
	
	public int getProjectHours(String projectName) throws TimesheetException {
        return -1;
	}
	
	public int getWorkedHoursPerDay(String workerID, int day) throws TimesheetException {
        return -1;
	}
	
	// R5
	public Map<String, Integer> countActivitiesPerWorker() {
        return null;
	}
	
	public Map<String, Integer> getRemainingHoursPerProject() {
        return null;
	}
	
	public Map<String, Map<String, Integer>> getHoursPerActivityPerProject() {
        return null;
	}
}
