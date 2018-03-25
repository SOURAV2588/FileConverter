package com.sourav.FileConverter;

import com.sourav.FileConverter.model.Person;
import com.sourav.FileConverter.model.PersonList;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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

    public String personListToXmlConverter(List<Person> personList){
        XStream xStream = new XStream();
        xStream.alias("person",Person.class);
        xStream.alias("personList",PersonList.class);
        xStream.addImplicitCollection(PersonList.class,"list");

        PersonList list = new PersonList();
        personList.forEach(list::add);

        //This is for de-serialization
        /*String xml = "<persons><person>...</person></persons>";
        PersonList pList = (PersonList)xstream.fromXML(xml);*/

        return xStream.toXML(list);
    }
}
