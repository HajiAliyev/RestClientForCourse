import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Method {

    public static String sendGet(String url) throws Exception {

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("Accept", "application/json");

        int responseCode = con.getResponseCode();

//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code form 'GET' : " + responseCode);

//        try (BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()))) {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));


//        StringBuilder response = new StringBuilder();
//        String line;

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
//        System.out.println(response.toString());

        return response.toString();
    }


    public static String sendPost(String url, String data) throws Exception {

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-type", "application/xml");
//        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

//        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345"; //bu url-e gondereceyim 'urlParameters'  data-dir.

        // Send post request
        con.setDoOutput(true);

//        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//            wr.writeBytes(urlParameters);
//            wr.flush();
//        }

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(data);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + data);
//        System.out.println("Response Code from 'POST' : " + responseCode);

//        try (BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()))) {
//
//
//            String line;
//            StringBuilder response = new StringBuilder();
//
//            while ((line = in.readLine()) != null) {
//                response.append(line);
//            }
//
//            //print result
//            System.out.println(response.toString());
//
//        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));


        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return response.toString();
    }


}
