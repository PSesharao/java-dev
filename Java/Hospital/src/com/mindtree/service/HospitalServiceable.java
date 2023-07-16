package com.mindtree.service;

import com.mindtree.entity.Doctor;
import com.mindtree.entity.Hospital;
import com.mindtree.entity.Patient;

public interface HospitalServiceable {
	Patient[] addEntry(Patient[] patientRecord, Patient patientEntry);

	Hospital[] addEntry(Hospital[] hospitalRecord, Hospital hospitalEntry);

	Doctor[] addEntry(Doctor[] doctorRecord, Doctor doctorEntry);

	String[] addEntry(String[] symList, String symptom);

	int getPrevRecord(Patient[] patientRecord, String id);

	int getPrevRecord(Hospital[] hospitalRecord, String id);

	int getPrevRecord(Doctor[] doctorRecord, String id);

	Patient[] getAllPatientsWithSymptom(Patient[] patientRecord, String symptom);

	Doctor[] getAllDoctorsWithLocationAndSpec(Hospital[] hospitalRecord, String location, String specialization);

	Patient[] getPatientsUnder19AtHospital(Hospital hospital);

	Doctor[] getDoctorsSortedByPatientCount(Hospital hospital);
}
