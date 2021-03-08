package first_task.client;

import first_task.api.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// remember to execute clean after changing active env
public class App {

    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }

    public static void main(String[] args) throws IOException {
//        final String email = "bob@example.com";
//        final String name = "Bob";
//        final String password = "123456";
//        final Integer age = 19;


        String mode = new App().loadPropertiesFile("properties-from-pom.properties").getProperty("env");

        String resFile = "config." + mode + ".properties";

        Properties properties = new App().loadPropertiesFile(resFile);

        final String email = properties.getProperty("email");
        final String name = properties.getProperty("name");
        final String password = properties.getProperty("password");
        final Integer age = Integer.parseInt(properties.getProperty("age"));

        Person person = new Person();
        person.setEmail(email);
        person.setName(name);
        person.setPassword(password);
        person.setAge(age);
        System.out.println(person.toString());


        Properties temp = new App().loadPropertiesFile("config.properties");
//        temp.forEach((k, v) -> System.out.println(k +" : "+ v));

    }
}