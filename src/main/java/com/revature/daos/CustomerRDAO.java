package com.revature.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.StartMenuController;
import com.revature.models.Customer;

public class CustomerRDAO {
	private Logger log = LoggerFactory.getLogger(StartMenuController.class);

	public void writeCustomer(Customer customerR) {
		File customersR = new File("src//main//resources//customersR.txt");

		try {
			if (customersR.createNewFile()) {
				log.info("Created new registered customer record");
			}
//			else {
//				log.info("Customer record already exists");
//			}
		} catch (IOException e) {
			log.error("Something went wrong trying to access customer record " + e.getMessage());
		}

		try (FileWriter writer = new FileWriter("src//main//resources//customersR.txt", true)) {
			StringBuilder builder = new StringBuilder(customerR.getFirstName());
			builder.append(", " + customerR.getLastName());
			builder.append(", " + customerR.getPassWord());
			builder.append(", " + customerR.getAddress());
			builder.append(", " + customerR.getUserName() + "\n");

			String customerRString = new String(builder);
			writer.write(customerRString);
			;

		} catch (IOException e) {
			log.error("Could not write customer record to file: " + e.getMessage());
		}

	}

	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> allCustomers = new ArrayList<>();
		try (Scanner scan = new Scanner(new File("src//main//resources//customersR.txt"))) {
			while (scan.hasNextLine()) {
				String customerString = scan.nextLine();
				String[] customerDeets = customerString.split(",");
//				allCustomers.add(new Customer(customerDeets[0], customerDeets[1], customerDeets[2], customerDeets[3],
//						customerDeets[4]));
			}
		} catch (Exception e) {
			log.error("Something went wrong retrieving customers:" + e.getMessage());
		}
		return allCustomers;
	}

}
