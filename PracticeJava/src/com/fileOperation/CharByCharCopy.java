package com.fileOperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharByCharCopy {
	//Creating a method which read file and write to a destination file.
	public static void copyFileCharByChar(String sourceFile, String destinationFile) {
		try(
				FileReader reader = new FileReader(sourceFile);
				FileWriter writer = new FileWriter(destinationFile)
				){
			int character;
			while ((character = reader.read()) != -1) {
				writer.write(character);
			}
			System.out.println("File is copied character by character......");
			
		}catch(IOException e) {
			System.err.println("Error Occured: "+ e.getMessage());
		}
	}
	
	//Search string and write to text file
	public static void searchAndWrite(String sourceFile, String destinationFile, String searchTerm) {
		try(
				BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))
				
				){
			String line;
			while((line = reader.readLine()) != null) {
				if(line.toLowerCase().contains(searchTerm.toLowerCase())) {
					writer.write(line);
					writer.newLine();
					
				}
			}
			System.out.println("Search completed. Matching lines written to output....");
			
		}catch(IOException e){
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "D:\\TestData\\README.txt";
		String destination = "D:\\TestData\\DestinationFile.txt";
		String keywork = "Maven";
		//copyFileCharByChar(source, destination);
		searchAndWrite(source, destination, keywork.toLowerCase());

	}

}
