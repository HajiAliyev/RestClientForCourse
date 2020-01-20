
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;


public class MainClass {

    public static void main(String[] args) {

        Logger LOGGER = Logger.getLogger(MainClass.class);

        try {
            String url = "http://localhost:7676/Course/api/webServices/getStudentById?studentId=1";
//            String name = "Saleh"; // bunlar netbeans-da Swing fieldlarindan da gele biler !
//            String surname ="Abbasov";
            String result =  Method.sendGet(url);
            LOGGER.info("Request: "+url);

            LOGGER.info(result);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(result);
            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            String surname = (String) jsonObject.get("surname");
            String address = (String) jsonObject.get("address");
            String dob = (String) jsonObject.get("dob");

//            Object statusObject = (Object) parser.parse((String) jsonObject.get("status"));
//            JSONObject statusJsonObject = (JSONObject) obj;

            JSONObject statusJsonObject = (JSONObject) jsonObject.get("status");
            String statusCode = (String) statusJsonObject.get("statusCode");
            String statusMessage = (String) statusJsonObject.get("statusMessage");

            LOGGER.info("Response: " + name + " -- " + surname + " -- " + address + " -- " + dob +" -- "+ statusCode + " -- " + statusMessage);
//            System.out.println(name + " -- " + surname + " -- " + address + " -- " + dob +" -- "+ statusCode + " -- " + statusMessage);



//            String url = "http://localhost:8686/Course/api/webServices/addStudent";
//            String data = "<student>\n" +
//                    "<name>"+name+"</name>\n" +
//                    "<surname>"+surname+"</surname>\n" +
//                    "<address>London</address>\n" +
//                    "<dob>1997-07-21</dob>\n" +
//                    "</student>";
//            String result = Method.sendPost(url, data);
//            System.out.println(result);
//            if(result.contains("success")){
//                System.out.println("Student is successfully added!");
//            }






//            File file = new File("C:\\file.xml");

//            //XML ile parse etmek
//            InputStream stream = new ByteArrayInputStream(result.getBytes(StandardCharsets.UTF_8));
//
//            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            Student student = (Student) jaxbUnmarshaller.unmarshal(stream);
//            System.out.println(student);
//
//            if(student.getStatus().getStatusCode() == 1) {
//                System.out.println(student.getName() +" -- "+ student.getSurname() +" -- " + student.getAddress() +" -- "+student.getDob() );
//            }
        } catch (Exception e) {
            LOGGER.error("Internal Exception",e);
//            e.printStackTrace();
        }
    }
}
