package com.sourav.FileConverter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.*;
@Slf4j
public class SampleFileReader {

    @Test
    public void testRead(){

        try {
            //spring way(using resourceUtil) to read the file
            File file = ResourceUtils.getFile("classpath:MockData/Detailed person data with 8 fields.csv");
            BufferedReader bufferedReader  = null;
            String line = "";
            String csvSplitBy = ",";
            bufferedReader = new BufferedReader(new FileReader(file.toString()));
            while ((line = bufferedReader.readLine())!=null){
                //line =bufferedReader.readLine();
                String[] person = line.split(csvSplitBy);
                //System.out.println("Person : Title: "+person[0]+" ,Firstname : "+person[1]+" Lastname :"+person[2]);
                log.info("Person : Title: "+person[0]+" ,Firstname : "+person[1]+" Lastname :"+person[2]);
            }
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
}
