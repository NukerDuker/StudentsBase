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
    private static List objects;

    public static void marshal(XmlModel model) {
        try {
            logger.info("ֿטרול xml");
            JAXBContext context = JAXBContext.newInstance(model.getClass());
            mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            logger.info("ׁמחהאול פאיכ");
            String path = "src/main/resources/ " + formatter.format(System.currentTimeMillis()) + ".xml";
            File file = new File(path);
            logger.info("װאיכ סמחהאם?");
            logger.info(Boolean.toString(file.createNewFile()));
            mar.marshal(model, file);
        } catch (IOException | JAXBException e) {
            logger.error(e.getMessage());
            Arrays.stream(e.getStackTrace()).forEach(logger::error);
        }
    }

    public static void writeXml() {

    }
}
