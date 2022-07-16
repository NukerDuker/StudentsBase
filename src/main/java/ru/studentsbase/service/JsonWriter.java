package ru.studentsbase.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.xmlmodel.ObjectFactory;
import org.eclipse.persistence.oxm.MediaType;
import ru.studentsbase.model.XmlModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;

import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class JsonWriter {

    private static final Logger log = LogManager.getLogger(JsonWriter.class.getName());
    private static Marshaller mar;
    private static DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);

    public static void marshal(XmlModel model) {
        try {
            log.info("Подготовка к записи JSON");
            JAXBContext jaxbContext = JAXBContextFactory.createContext(new Class[]{model.getClass(), ObjectFactory.class}, null);
            mar = jaxbContext.createMarshaller();

            // To format JSON
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Set JSON type
            mar.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
            mar.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            //Create file
            log.info("Создаем директорию и файл");
            File dir = new File("src/main/jsonDocs");
            File file = new File("src/main/jsonDocs/ " + formatter.format(System.currentTimeMillis()) + ".json");
            log.info("Директория создана: " + dir.mkdir());
            log.info("Файл создан: " + file.createNewFile());

            //Write to file
            mar.marshal(model, file);

        } catch (JAXBException | IOException e) {
            log.error(e.getMessage());
        }
    }
}
