package course;

public class Course {
	private String courseName;
	private int duration;
	private int fee;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public Course(String courseName, int duration, int fee) {
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}
}
