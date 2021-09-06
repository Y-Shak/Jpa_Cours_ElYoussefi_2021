package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

@SpringBootApplication
public class JpaElYoussefiCoursApplication implements CommandLineRunner{
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaElYoussefiCoursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null , "hassan ", new Date(), 234, true));
		patientRepository.save(new Patient(null , "Yousra ", new Date(), 156, false));
		patientRepository.save(new Patient(null , "Ilyass ", new Date(), 29, false));
		patientRepository.save(new Patient(null , "Mina ", new Date(), 1902, false));
		
		patientRepository.findAll().forEach(System.out::println);
		System.out.println("********************************************");
		
		Patient patient = patientRepository.findById(3L).get();
		System.out.println(patient.getNom());
		System.out.println("********************************************");
		patientRepository.findByNomContains("Mina").forEach(System.out::println);
		System.out.println("********************************************");
		patientRepository.findByMalade(false).forEach(System.out::println);
		System.out.println("********************************************");
		
		
	}

}
