package Code.Helpers;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonObjHelper {

    public static void createCompany(String username, String password, String companyPhone, String HQAddress){
        JSONObject obj = new JSONObject();

        obj.put("username", username);
        obj.put("password", password);
        obj.put("companyPhone", companyPhone);
        obj.put("HQAddress", HQAddress);

        try {

            FileWriter file = new FileWriter("company.json");
            file.append(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj.toJSONString());
    }
}
