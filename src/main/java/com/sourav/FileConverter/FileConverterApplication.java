package com.sourav.FileConverter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class FileConverterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FileConverterApplication.class, args);
	}

	@Override
	public void run(String... strings){
		//give a path to a csv file
        String csvFile = "F:/Test Mock Data/Detailed person data with 8 fields.csv";
        BufferedReader bufferedReader  = null;
        String line = "";
        String csvSplitBy = ",";

        try{
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while (bufferedReader.readLine()!=null){
                line =bufferedReader.readLine();
                String[] person = line.split(csvSplitBy);
                System.out.println("Person : Title: "+person[0]+" ,Firstname : "+person[1]+" Lastname :"+person[2]);
            }

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("IOException");
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
