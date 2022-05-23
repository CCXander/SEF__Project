package Code.Helpers;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Code.Controllers.LoginController;

public class JsonObjHelper {

    public static void createCompany(String username, String password, String companyPhone, String HQAddress) {
        JSONObject obj = new JSONObject();
        JSONArray companyList;

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/company.json");
            Object jsonObj = parser.parse(reader);
            companyList = (JSONArray) jsonObj;

            obj.put("username", username);
            obj.put("password", password);
            obj.put("companyPhone", companyPhone);
            obj.put("HQAddress", HQAddress);

            companyList.add(obj);

            try {

                FileWriter file = new FileWriter("src/main/resources/JsonDatabases/company.json");
                file.write(companyList.toJSONString());
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createCustomer(String username, String password, String customerPhone, String personalAddress) {
        JSONObject obj = new JSONObject();
        JSONArray customerList;

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/customer.json");
            Object jsonObj = parser.parse(reader);
            customerList = (JSONArray) jsonObj;

            obj.put("username", username);
            obj.put("password", password);
            obj.put("customerPhone", customerPhone);
            obj.put("personalAddress", personalAddress);

            customerList.add(obj);

            try {

                FileWriter file = new FileWriter("src/main/resources/JsonDatabases/customer.json");
                file.write(customerList.toJSONString());
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int userType;//0-inital 1-incorect 2-customer 3-company

    public static int readUser (String username, String password){
        JSONArray userList;

        userType=0;


        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/customer.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();
                if(element.toString().contains("\"username\":\""+username+"\"") && element.toString().contains("\"password\":\""+Cryptography.encriptCypher(password,4)+"\"")) {
                    System.out.println(element);
                    userType=2;
                }
            }


                reader = new FileReader("src/main/resources/JsonDatabases/company.json");
            jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            iterator = userList.iterator();
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();
                if(element.toString().contains("\"username\":\""+username+"\"") && element.toString().contains("\"password\":\""+Cryptography.encriptCypher(password,4)+"\"")) {
                    System.out.println(element);
                    userType=3;
                }
            }

            if(userType==0){
                userType=1;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return userType;
        }
    }

    public static void createProduct(String name, String description, String price) {
        JSONObject obj = new JSONObject();
        JSONArray productList;

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/products.json");
            Object jsonObj = parser.parse(reader);
            productList = (JSONArray) jsonObj;

            obj.put("name", name);
            obj.put("description", description);
            obj.put("price", price);
            obj.put("company", LoginController.username);

            productList.add(obj);

            try {

                FileWriter file = new FileWriter("src/main/resources/JsonDatabases/products.json");
                file.write(productList.toJSONString());
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String printProducts (){
        JSONArray userList;
        String products="";
        String productName="";
        String productDescription="";
        String productPrice="";
        String productCompany="";

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/products.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();

                JSONObject json = (JSONObject) parser.parse(element.toJSONString());
                productName = (String) json.get("name");
                productDescription = (String) json.get("description");
                productPrice = (String) json.get("price");
                productCompany = (String) json.get("company");


                products+="Name: "+productName+"\nDescription: "+productDescription+"\nPrice: "+productPrice+"\nCompany: "+productCompany+"\n\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return products;
        }
    }

    public static String deleteProducts (String name){
        JSONArray userList;
        String products="";


        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/products.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            int i=0;
            int ok=1;
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();
                JSONObject json = (JSONObject) parser.parse(element.toJSONString());
                if(name.equals(json.get("name"))){
                   break;
                }else{
                    if(ok==1)
                        i++;
                }
            }

            userList.remove(i);

            try {

                FileWriter file = new FileWriter("src/main/resources/JsonDatabases/products.json");
                file.write(userList.toJSONString());
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return products;
        }
    }

    public static String[] setModifyText (String name) {
        JSONArray userList;
        String[] values = new String[3];

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/products.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            int i=0;
            int ok=1;
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();
                JSONObject json = (JSONObject) parser.parse(element.toJSONString());
                if(name.equals(json.get("name"))){
                    values[0]=name;
                    values[1]=(String) json.get("description");
                    values[2]=(String)json.get("price");
                    break;
                }else{
                    if(ok==1)
                        i++;
                }
            }

            try {

                FileWriter file = new FileWriter("src/main/resources/JsonDatabases/products.json");
                file.write(userList.toJSONString());
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {;
            return values;
        }
    }


    public static void modifyProduct (String name,String description,String price,String oldName) {
        JSONArray userList;

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/products.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            int i=0;
            int ok=1;
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();
                JSONObject json = (JSONObject) parser.parse(element.toJSONString());
                if(oldName.equals(json.get("name"))){
                    break;
                }else{
                    if(ok==1)
                        i++;
                }
            }

            userList.remove(i);

            JSONObject obj = new JSONObject();
            obj.put("name", name);
            obj.put("description", description);
            obj.put("price", price);
            obj.put("company", LoginController.username);
            userList.add(obj);

            try {

                FileWriter file = new FileWriter("src/main/resources/JsonDatabases/products.json");
                file.write(userList.toJSONString());
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean productExists (String name){
        JSONArray userList;

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/products.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();
                JSONObject json = (JSONObject) parser.parse(element.toJSONString());
                if(name.equals(json.get("name"))){
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String printProduct (String name){
        JSONArray userList;
        String products="";
        String productName="";
        String productDescription="";
        String productPrice="";
        String productCompany="";

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/products.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();

                JSONObject json = (JSONObject) parser.parse(element.toJSONString());
                if(name.equals(json.get("name"))) {
                    productName = (String) json.get("name");
                    productDescription = (String) json.get("description");
                    productPrice = (String) json.get("price");
                    productCompany = (String) json.get("company");
                    products+="Name: "+productName+"\nDescription: "+productDescription+"\nPrice: "+productPrice+"\nCompany: "+productCompany+"\n\n";
                    return products;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return products;
        }
    }

    public static String getAddress (String name) {
        String Address="";
        JSONArray userList;

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/customer.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();

                JSONObject json = (JSONObject) parser.parse(element.toJSONString());
                if(name.equals(json.get("username"))) {
                    Address=(String) json.get("personalAddress");
                    return Address;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return Address;
        }
    }

    public static String getPrice (String name) {
        String Price="";
        JSONArray userList;

        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/resources/JsonDatabases/products.json");
            Object jsonObj = parser.parse(reader);
            userList = (JSONArray) jsonObj;

            Iterator<JSONObject> iterator = userList.iterator();
            while(iterator.hasNext()) {
                JSONObject element = iterator.next();

                JSONObject json = (JSONObject) parser.parse(element.toJSONString());
                if(name.equals(json.get("name"))) {
                    Price=(String) json.get("price");
                    return Price;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return Price;
        }
    }

}

