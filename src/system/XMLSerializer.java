package system;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import dataManager.OrganizationManager;
import organization.Address;
import organization.Coordinates;
import organization.Organization;
import organization.OrganizationType;

import java.io.*;
import java.util.ArrayList;

public class XMLSerializer {
    public XStream xstream;

    public XMLSerializer(){
        xstream = new XStream(new StaxDriver());
        xstream.alias("address", Address.class);
        xstream.alias("coordinates", Coordinates.class);
        xstream.alias("organization", Organization.class);
        xstream.alias("organizationType", OrganizationType.class);

        xstream.addImplicitCollection(OrganizationManager.class, "collection");

        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.allowTypeHierarchy(ArrayList.class);
        xstream.allowTypeHierarchy(String.class);
        xstream.ignoreUnknownElements();
    }


    public String serialize(ArrayList<Organization> data) {
        String rawData = xstream.toXML(data);
        return rawData;
    }
    public ArrayList<Organization> deserialize() {
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(ArrayList.class);
        xstream.allowTypeHierarchy(String.class);
        xstream.allowTypes(new Class[] {ArrayList.class, Organization.class});
        xstream.ignoreUnknownElements();

        ArrayList<Organization> data = new ArrayList<>();

        File file = new File("/Users/markvassilovskiy/Documents/JProjects/lab5_proga/src/lab.xml");
        if (!file.exists()) {
            System.out.println("Файл не существует");
            return null;
        }

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("/Users/markvassilovskiy/Documents/JProjects/lab5_proga/src/lab.xml"))) {
            char[] buffer = new char[1024];
            int bytesRead;
            StringBuilder stringBuilder = new StringBuilder();
            while ((bytesRead = inputStreamReader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, bytesRead);
            }
            String rawData = stringBuilder.toString();
            data = (ArrayList<Organization>) xstream.fromXML(rawData);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }
        return data;
    }
}