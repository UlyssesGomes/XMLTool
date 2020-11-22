package utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * Class to save and load java objects to xml file.
 * @author Ulysses Gomes
 */
public class XMLFileTool {
    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    /**
     * Transform a java object into a xml file. The object class must be annoted with @XmlRootElement
     * and attribute name must be unique.
     * @param  object - object that you desire to save into a xml file.
     * @param file - file name, if not exists, will be created.
     * @param classRef - class of object passed to the first parameter.
     * @throws JAXBException
     * @throws IOException
     */
    public void saveObject(Object object, File file, Class classRef) throws JAXBException, IOException {
        context = JAXBContext.newInstance(classRef);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        createFileIfNotExists(file);
        marshaller.marshal(object, file);
    }

    /**
     * Load xml file to a respective java object. The object class must be annoted with @XmlRootElement
     * and attribute name must be unique.
     * @param file - file name, if not exists, a exception will be throw.
     * @param classRef - class of object that you desire load.
     * @return a instance of class loaded from xml file.
     * @throws JAXBException
     * @throws IOException
     */
    public Object loadObjectFromXmlFile(File file, Class classRef) throws JAXBException, IOException {
        context = JAXBContext.newInstance(classRef);
        unmarshaller = context.createUnmarshaller();
        if(!file.isFile()) {
            throw new IOException("Nenhum arquivo com nome " + file.getName() + " encontrado.");
        }
        createFileIfNotExists(file);
        Object object = unmarshaller.unmarshal(file);
        return object;
    }

    /**
     * Receive a file object and verify if file is valid
     * @param file - a file that you need to verify.
     * @throws IOException
     */
    private void createFileIfNotExists(File file) throws IOException {
        if(!(file.isFile() && file.canRead() && file.canWrite())) {
            file.createNewFile();
        }
    }
}
