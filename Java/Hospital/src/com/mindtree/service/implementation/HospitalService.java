package com.mindtree.service.implementation;

import com.mindtree.entity.Doctor;
import com.mindtree.entity.Hospital;
import com.mindtree.entity.Patient;
import com.mindtree.service.HospitalServiceable;

public class HospitalService implements HospitalServiceable {

	@Override
	public Patient[] addEntry(Patient[] patientRecord, Patient patientEntry) {
		int currLen = patientRecord.length;
		Patient temp[] = new Patient[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = patientRecord[i];
		temp[currLen] = patientEntry;
		return temp;
	}

	@Override
	public Hospital[] addEntry(Hospital[] hospitalRecord, Hospital hospitalEntry) {
		int currLen = hospitalRecord.length;
		Hospital temp[] = new Hospital[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = hospitalRecord[i];
		temp[currLen] = hospitalEntry;
		return temp;
	}

	@Override
	public Doctor[] addEntry(Doctor[] doctorRecord, Doctor doctorEntry) {
		int currLen = doctorRecord.length;
		Doctor temp[] = new Doctor[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = doctorRecord[i];
		temp[currLen] = doctorEntry;
		return temp;
	}

	@Override
	public int getPrevRecord(Patient[] patientRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < patientRecord.length; i++) {
			if (patientRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	@Override
	public int getPrevRecord(Hospital[] hospitalRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < hospitalRecord.length; i++) {
			if (hospitalRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	@Override
	public int getPrevRecord(Doctor[] doctorRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < doctorRecord.length; i++) {
			if (doctorRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	@Override
	public Patient[] getAllPatientsWithSymptom(Patient[] patientRecord, String symptom) {
		Patient[] patientList = new Patient[0];
		for (int i = 0; i < patientRecord.length; i++) {
			for (int j = 0; j < patientRecord[i].getSymptoms().length; j++)
				if (patientRecord[i].getSymptoms()[j].compareTo(symptom) == 0) {
					patientList = addEntry(patientList, patientRecord[i]);
					break;
				}
		}
		return patientList;
	}

	@Override
	public Doctor[] getAllDoctorsWithLocationAndSpec(Hospital[] hospitalRecord, String location,
			String specialization) {
		Doctor[] doctorList = new Doctor[0];
		for (int i = 0; i < hospitalRecord.length; i++) {
			if (hospitalRecord[i].getLocation().compareTo(location) == 0) {
				for (int j = 0; j < hospitalRecord[i].getDoctorList().length; j++) {
					if (hospitalRecord[i].getDoctorList()[j].getSpecialization().compareTo(specialization) == 0) {
						doctorList = addEntry(doctorList, hospitalRecord[i].getDoctorList()[j]);
						break;
					}
				}
			}
		}
		return doctorList;
	}

	@Override
	public Patient[] getPatientsUnder19AtHospital(Hospital hospital) {
		Patient[] patientunder19 = new Patient[0];
		for (int i = 0; i < hospital.getDoctorList().length; i++) {
			for (int j = 0; j < hospital.getDoctorList()[i].getPatientList().length; j++) {
				if (hospital.getDoctorList()[i].getPatientList()[j].getAge() < 19)
					patientunder19 = addEntry(patientunder19, hospital.getDoctorList()[i].getPatientList()[j]);
			}
		}
		return patientunder19;
	}

	@Override
	public Doctor[] getDoctorsSortedByPatientCount(Hospital hospital) {
		for (int i = 0; i < hospital.getDoctorList().length - 1; i++) {
			for (int j = 0; j < hospital.getDoctorList().length - 1 - i; j++)
				if (hospital.getDoctorList()[j].getPatientList().length > hospital.getDoctorList()[j + 1]
						.getPatientList().length) {
					Doctor temp = hospital.getDoctorList()[j];
					hospital.getDoctorList()[j] = hospital.getDoctorList()[j + 1];
					hospital.getDoctorList()[j + 1] = temp;
				}
		}
		return hospital.getDoctorList();
	}

	@Override
	public String[] addEntry(String[] symList, String symptom) {
		int currLen = symList.length;
		String temp[] = new String[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = symList[i];
		temp[currLen] = symptom;
		return temp;
	}
}
