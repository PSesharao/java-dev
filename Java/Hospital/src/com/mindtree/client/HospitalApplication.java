package com.mindtree.client;

import java.util.Scanner;

import com.mindtree.entity.Doctor;
import com.mindtree.entity.Hospital;
import com.mindtree.entity.Name;
import com.mindtree.entity.Patient;
import com.mindtree.service.implementation.HospitalService;

public class HospitalApplication {
	private static Scanner input = new Scanner(System.in);
	private static HospitalService hospSer = new HospitalService();

	public static void main(String[] args) {
		HospitalApplication hospApp = new HospitalApplication();
		hospApp.driverMethod();
	}

	private void driverMethod() {
		int choice;
		int prevHistory;
		String hospitalId;
		String patientId;
		String doctorId;
		String symptom;
		Patient[] patientRecord = new Patient[0];
		Hospital[] hospitalRecord = new Hospital[0];
		Doctor[] doctorRecord = new Doctor[0];
		boolean isEntered;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				do {
					isEntered = true;
					System.out.println("Reading patient id :");
					patientId = getValidatedInput("id");
					prevHistory = hospSer.getPrevRecord(patientRecord, patientId);
					if (prevHistory == -1) {
						System.out.println("Reading patient details :");
						Patient patientEntry = new Patient(patientId,
								new Name(getValidatedInput("firstName"), getValidatedInput("lastName")),
								getValidatedInteger("age"));
						System.out.println("Enter no of symptoms :");
						int noOfsym = getValidatedInteger("no");
						patientEntry.setSymptoms(new String[0]);
						for (int i = 0; i < noOfsym; i++) {
							System.out.println("Enter symptom " + (i + 1) + ":");
							symptom = getValidatedInput("symptoms");
							patientEntry.setSymptoms(hospSer.addEntry(patientEntry.getSymptoms(), symptom));
						}
						patientRecord = hospSer.addEntry(patientRecord, patientEntry);
					} else {
						System.out.println("The patient " + (patientId) + " has been registered before!!Try again");
						isEntered = false;
					}
				} while (!isEntered);
				break;
			case 2:
				do {
					isEntered = true;
					System.out.println("Reading doctor id :");
					doctorId = getValidatedInput("id");
					prevHistory = hospSer.getPrevRecord(doctorRecord, doctorId);
					if (prevHistory == -1) {
						System.out.println("Reading doctor details :");
						Doctor doctorEntry = new Doctor(doctorId,
								new Name(getValidatedInput("firstName"), getValidatedInput("lastName")),
								getValidatedInput("specialization"));
						System.out.println("Reading no of patients under doctor:");
						int noOfPat = getValidatedInteger("no");
						if (noOfPat > patientRecord.length) {
							System.out.println("You dont have enough patients to add under doctor , add more patients");
						} else {
							doctorEntry.setPatientList(new Patient[0]);
							boolean isValid;
							System.out.println("Reading patient details ");
							for (int i = 0; i < noOfPat; i++) {
								do {
									isValid = true;
									System.out.println("Reading patient id of patient:" + (i + 1));
									patientId = getValidatedInput("id");
									prevHistory = hospSer.getPrevRecord(patientRecord, patientId);
									if (prevHistory == -1) {
										isValid = false;
										System.out.println("The patient " + (patientId)
												+ " has not been registered before, Try again");
									} else {
										int prevLocalHistory = hospSer.getPrevRecord(doctorEntry.getPatientList(),
												patientId);
										if (prevLocalHistory == -1) {
											doctorEntry.setPatientList(hospSer.addEntry(doctorEntry.getPatientList(),
													patientRecord[prevHistory]));

										} else {
											System.out.println("The patient " + (patientId)
													+ " has been added to the doctor already, Try again");
											isValid = false;
										}
									}
								} while (!isValid);

							}

							doctorRecord = hospSer.addEntry(doctorRecord, doctorEntry);
						}
					} else {
						System.out.println("The doctor " + (doctorId) + " has been registered before Try again");
						isEntered = false;
					}
				} while (!isEntered);
				break;
			case 3:
				do {
					isEntered = true;
					System.out.println("Reading hospital id :");
					hospitalId = getValidatedInput("id");
					prevHistory = hospSer.getPrevRecord(hospitalRecord, hospitalId);
					if (prevHistory == -1) {
						System.out.println("Reading hospital details :");
						Hospital hospitalEntry = new Hospital(hospitalId, getValidatedInput("name"),
								getValidatedInput("location"));
						System.out.println("Reading no of doctors under hospital :");
						int noOfDoc = getValidatedInteger("no");
						if (noOfDoc > patientRecord.length) {
							System.out.println("You dont have enough doctors to add under hospital , add more doctors");
						} else {
							hospitalEntry.setDoctorList(new Doctor[0]);
							boolean isValid;
							System.out.println("Reading doctor details ");
							for (int i = 0; i < noOfDoc; i++) {
								do {
									isValid = true;
									System.out.println("Reading doctor id of doctor:" + (i + 1));
									doctorId = getValidatedInput("id");
									prevHistory = hospSer.getPrevRecord(doctorRecord, doctorId);
									if (prevHistory == -1) {
										isValid = false;
										System.out.println("The doctor " + (doctorId)
												+ " has not been registered before, Try again");
									} else {
										int prevLocalHistory = hospSer.getPrevRecord(hospitalEntry.getDoctorList(),
												doctorId);
										if (prevLocalHistory == -1) {
											hospitalEntry.setDoctorList(hospSer.addEntry(hospitalEntry.getDoctorList(),
													doctorRecord[prevHistory]));

										} else {
											System.out.println("The doctor " + (doctorId)
													+ " has been added to the hospital already, Try again");
											isValid = false;
										}
									}
								} while (!isValid);
							}
							hospitalRecord = hospSer.addEntry(hospitalRecord, hospitalEntry);
						}
					} else {
						System.out.println("The hospital " + (hospitalId) + " has been registered before Try again");
						isEntered = false;
					}
				} while (!isEntered);
				break;
			case 4:
				symptom = getValidatedInput("symptoms");
				Patient[] patientList = hospSer.getAllPatientsWithSymptom(patientRecord, symptom);
				for (int i = 0; i < patientList.length; i++)
					showPatient(patientList[i]);
				break;
			case 5:
				String location = getValidatedInput("location");
				String spec = getValidatedInput("specialization");
				Doctor[] doctorList = hospSer.getAllDoctorsWithLocationAndSpec(hospitalRecord, location, spec);
				for (int i = 0; i < doctorList.length; i++)
					showDoctor(doctorList[i]);
				break;
			case 6:
				hospitalId = getValidatedInput("id");
				prevHistory = hospSer.getPrevRecord(hospitalRecord, hospitalId);
				if (prevHistory == -1)
					System.out.println("No such hospital " + (hospitalId) + " exists");
				else {
					Patient[] patientunder19 = hospSer.getPatientsUnder19AtHospital(hospitalRecord[prevHistory]);
					for (int i = 0; i < patientunder19.length; i++)
						showPatient(patientunder19[i]);
				}
				break;
			case 7:
				hospitalId = getValidatedInput("id");
				prevHistory = hospSer.getPrevRecord(hospitalRecord, hospitalId);
				if (prevHistory == -1)
					System.out.println("No such hospital " + (hospitalId) + " exists");
				else {
					Doctor[] sortedDoc = hospSer.getDoctorsSortedByPatientCount(hospitalRecord[prevHistory]);
					for (int i = 0; i < sortedDoc.length; i++)
						showDoctor(sortedDoc[i]);
				}
				break;
			case 8:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Enter right choice :");
			}
		} while (choice != 8);
	}

	private void showPatient(Patient patientEntry) {
		System.out.println("Patient Id:\t" + patientEntry.getId());
		System.out.println(
				"Patient name:\t" + patientEntry.getName().getFirstName() + " " + patientEntry.getName().getLastName());
		System.out.println("Patient age:\t" + patientEntry.getAge());
	}

	private void showDoctor(Doctor doctorEntry) {
		System.out.println("Doctor Id:\t" + doctorEntry.getId());
		System.out.println(
				"Doctor name:\t" + doctorEntry.getName().getFirstName() + " " + doctorEntry.getName().getLastName());
		System.out.println("Doctor specialization:\t" + doctorEntry.getSpecialization());
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Add new patient details:");
		System.out.println("2. Add new doctor details:");
		System.out.println("3. Add new hospital details:");
		System.out.println("4. Get all patients having symptoms provided by users");
		System.out.println("5. Get all doctors present at a given location and given specialization");
		System.out.println("6. Get all patients who are below 19 years and present at a given hospital");
		System.out.println("7. Get all doctors present in a hospital sorted by patient count");
		System.out.println("8. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		int inputChoice;
		switch (validationType) {
		case "firstName":
			do {
				isValid = true;
				System.out.println("Enter firstname in alphastring :");
				inputString = input.next();
				for (int i = 0; i < inputString.length(); i++)
					if (!((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
							|| (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'))) {
						System.out.println("You have not entered a alphastring!Try again!!");
						isValid = false;
						break;
					}
			} while (!isValid);
			return inputString;
		case "lastName":
			do {
				isValid = true;
				System.out.println("Enter lastname in alphastring :");
				inputString = input.next();
				for (int i = 0; i < inputString.length(); i++)
					if (!((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
							|| (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'))) {
						System.out.println("You have not entered a alphastring!Try again!!");
						isValid = false;
						break;
					}
			} while (!isValid);
			return inputString;
		case "name":
			do {
				isValid = true;
				System.out.println("Enter name in alphastring :");
				inputString = input.next();
				for (int i = 0; i < inputString.length(); i++)
					if (!((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
							|| (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'))) {
						System.out.println("You have not entered a alphastring!Try again!!");
						isValid = false;
						break;
					}
			} while (!isValid);
			return inputString;
		case "gender":
			do {
				isValid = true;
				System.out.println("Enter your gender:");
				System.out.println("1.Male");
				System.out.println("2.Female");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Male";
				else if (inputChoice == 2)
					inputString = "Female";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "symptoms":
			do {
				// String sympArray[] = {"fever","cough","tiredness","headache","sore
				// throat","diarrhoea","rashes","chest pain"};
				isValid = true;
				System.out.println("Enter symptom:");
				System.out.println("1.fever");
				System.out.println("2.cough");
				System.out.println("3.tiredness");
				System.out.println("4.headache");
				System.out.println("5.sore throat");
				System.out.println("6.diarrhoea");
				System.out.println("7.rashes");
				System.out.println("8.chest pain");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "fever";
				else if (inputChoice == 2)
					inputString = "cough";
				else if (inputChoice == 3)
					inputString = "tiredness";
				else if (inputChoice == 4)
					inputString = "headache";
				else if (inputChoice == 5)
					inputString = "sore throat";
				else if (inputChoice == 6)
					inputString = "diarrhoea";
				else if (inputChoice == 7)
					inputString = "rashes";
				else if (inputChoice == 8)
					inputString = "chest pain";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "specialization":
			do {
				// String specArray[] = {"Pediatrician","Gynecologist
				// ","Surgeon","Psychiatrist","Cardiologist","Dermatologist","Endocrinologist","Gastroenterologist"};
				isValid = true;
				System.out.println("Enter specialization:");
				System.out.println("1.Pediatrician");
				System.out.println("2.Gynecologist ");
				System.out.println("3.Surgeon");
				System.out.println("4.Psychiatrist");
				System.out.println("5.Cardiologist");
				System.out.println("6.Dermatologist");
				System.out.println("7.Endocrinologist");
				System.out.println("8.Gastroenterologist");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Pediatrician";
				else if (inputChoice == 2)
					inputString = "Gynecologist ";
				else if (inputChoice == 3)
					inputString = "Surgeon";
				else if (inputChoice == 4)
					inputString = "Psychiatrist";
				else if (inputChoice == 5)
					inputString = "Cardiologist";
				else if (inputChoice == 6)
					inputString = "Dermatologist";
				else if (inputChoice == 7)
					inputString = "Endocrinologist";
				else if (inputChoice == 8)
					inputString = "Gastroenterologist";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "id":
			do {
				isValid = true;
				System.out.println("Enter the id:");
				inputString = input.next();
				if (inputString.length() > 10) {
					System.out.println("The id should not be more than 10 character long");
					isValid = false;
				} else {
					for (int i = 0; i < inputString.length(); i++)
						if (!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')
								&& !(inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
								&& !(inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z')) {
							isValid = false;
							System.out.println("id should be alphanumeric,try again");
							break;

						}
				}
			} while (!isValid);
			return inputString;
		case "location":
			do {
				isValid = true;
				System.out.println("Choose the source:");
				System.out.println("1. Delhi");
				System.out.println("2. Mumbai");
				System.out.println("3. Chennai");
				System.out.println("4. Hyderabad");
				System.out.println("5. Bangalore");
				System.out.println("6. Vishakapatnam");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Delhi";
				else if (inputChoice == 2)
					inputString = "Mumbai";
				else if (inputChoice == 3)
					inputString = "Chennai";
				else if (inputChoice == 4)
					inputString = "Hyderabad";
				else if (inputChoice == 5)
					inputString = "Bangalore";
				else if (inputChoice == 6)
					inputString = "Vishakapatnam";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again");
				}
			} while (!isValid);
			return inputString;
		}
		return null;
	}

	private int getValidatedInteger(String validationType) {
		int number;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		case "age":
			do {
				isValid = true;
				System.out.println("Enter artist age :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 150) {
					isValid = false;
					System.out.println("The age is invalid try again!!");
				}
			} while (!isValid);
			return number;
		case "no":
			do {
				isValid = true;
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 8) {
					isValid = false;
					System.out.println("The size invalid try again!!");
				}
			} while (!isValid);
			return number;
		case "price":
			do {
				isValid = true;
				System.out.println("Enter the price :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 5000) {
					isValid = false;
					System.out.println("The price is invalid try again!!");
				}
			} while (!isValid);
			return number;
		}
		return -1;
	}

}
