package com.sourav.FileConverter;

import com.sourav.FileConverter.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class PersonToXml {

    private static final String FILE_NAME = "output.xml";

    public void personToXmlConverter(List<Person> personList){
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            personList.forEach(person -> {
                try {
                    marshaller.marshal(person,System.out);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            });

            //marshaller.marshal(person,new File(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
