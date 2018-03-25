package com.sourav.FileConverter;

import com.sourav.FileConverter.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CsvFileReader {

    @Test
    public void testRead(){

        try {
            List<Person> personList = new ArrayList<>();
            PersonToXml personToXml = new PersonToXml();

            //spring way(using resourceUtil) to read the file
            File file = ResourceUtils.getFile("classpath:MockData/Detailed person data with 8 fields.csv");
            BufferedReader bufferedReader  = null;
            String line = "";
            String csvSplitBy = ",";
            bufferedReader = new BufferedReader(new FileReader(file.toString()));
            //This is to skip the first line of the csv file
            //TODO: find an elegant solution
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine())!=null){
                String[] person = line.split(csvSplitBy);
                log.info("Person : Title: "+person[0]+" ,Firstname : "+person[1]+" Lastname :"+person[2]);
                Person readPerson = new Person();
                personPropertySetter(person,readPerson);
                //adding the person to the list
                personList.add(readPerson);
            }

            //converting to xml
            //personToXml.personToXmlConverter(personList);
            System.out.println(personToXml.personListToXmlConverter(personList));

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    log.info("IOException Thrown");
                }
            }
        }catch (FileNotFoundException e){
            log.error("File not found");
        }
        catch (IOException e){
            log.info("IOException");
        }
    }

    private void personPropertySetter(String[] person,Person readPerson){
        //setting all properties from the read file
        readPerson.setTitle(person[0]);
        readPerson.setFirstName(person[1]);
        readPerson.setLastName(person[2]);
        readPerson.setGender(person[3]);
        readPerson.setSsn(person[4]);
        readPerson.setPhone(Long.valueOf(person[5]));
        readPerson.setStreet_address(person[6]);
        readPerson.setEmail(person[7]);
    }
}
