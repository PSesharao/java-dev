package clock11;

public class ClockDiff {
	String inputString;

	public ClockDiff(String inputString) {
		this.inputString = inputString;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public double getAngleDifference() {
		int hours = getHours();
		int minutes = getMinutes();
		if (hours >= 12)
			hours -= 12;
		double hoursHandDrift = 0.5 * (hours * 60 + minutes);
		double minutesHandDrift = 6 * minutes;
		double driftDifference;
		if (hoursHandDrift > minutesHandDrift)
			driftDifference = hoursHandDrift - minutesHandDrift;
		else
			driftDifference = minutesHandDrift - hoursHandDrift;
		if (driftDifference > 180)
			driftDifference = 360 - driftDifference;
		return driftDifference;
	}

	public int getHours() {
		return (inputString.charAt(0) - '0') * 10 + (inputString.charAt(1) - '0');
	}

	public int getMinutes() {
		return (inputString.charAt(3) - '0') * 10 + (inputString.charAt(4) - '0');
	}

}
