package ru.studentsbase.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.studentsbase.model.XmlModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.List;

public class XmlWriter {

    private static final Logger logger = LogManager.getLogger(XmlWriter.class.getName());
    private static Marshaller mar;
    private static DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);

    public static void marshal(XmlModel model) {
        try {
            logger.info("Подготовка для записи xml");
            JAXBContext context = JAXBContext.newInstance(model.getClass());

            //Set type
            mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Create dir
            File directory = new File("src/main/xmlDocs");
            logger.info("Создаем директорию: " + directory.mkdir());

            //Create file
            File file = new File("src/main/xmlDocs/" + formatter.format(System.currentTimeMillis()) + ".xml");
            logger.info("Файл создан: " + file.createNewFile());

            //Write to file
            mar.marshal(model, file);
        } catch (IOException | JAXBException e) {
            logger.error(e.getMessage());
            Arrays.stream(e.getStackTrace()).forEach(logger::error);
        }
    }
}
