package vehicle;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VehicleBO {
	private Map<String,String> vehicleMap = new TreeMap<String,String>();
	public Map<String,String> getVehicleMap()
	{
		return vehicleMap;
	}
	public void setVehicleMap(Map<String,String> vehicleMap)
	{
		this.vehicleMap=vehicleMap;
	}
	public void addVehicle(String registrationNumber,String mobileNumber)
	{
		vehicleMap.put(registrationNumber, mobileNumber);
	}
	public List<String> filterVehicleByRegistration(String registrationState)
	{
		LinkedList<String> list = new LinkedList<String>();
		
		return null;
	}
}
