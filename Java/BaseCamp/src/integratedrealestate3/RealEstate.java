package integratedrealestate3;

public class RealEstate {
	private int typeOfBHK;
	private String accomodationType;
	private String housingType;

	public int getTypeOfBHK() {
		return typeOfBHK;
	}

	public void setTypeOfBHK(int typeOfBHK) {
		this.typeOfBHK = typeOfBHK;
	}

	public String getAccomodationType() {
		return accomodationType;
	}

	public void setAccomodationType(String accomodationType) {
		this.accomodationType = accomodationType;
	}

	public String getHousingType() {
		return housingType;
	}

	public void setHousingType(String housingType) {
		this.housingType = housingType;
	}

	public RealEstate(int typeOfBHK, String accomodationType, String housingType) {
		this.typeOfBHK = typeOfBHK;
		this.accomodationType = accomodationType;
		this.housingType = housingType;
	}

	public void displayRealEstateRecord() {
		System.out.println("typeOfBHK :" + this.getTypeOfBHK());
		System.out.println("accomodationType :" + this.getAccomodationType());
		System.out.println("housingType :" + this.getHousingType());
	}
}
