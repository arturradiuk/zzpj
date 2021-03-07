package first_task.client;

import first_task.api.Person;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String email = "bob@example.com";
        final String name = "Bob";
        final String password = "123456";

        Person person = new Person();
        person.setEmail(email);
        person.setName(name);
        person.setPassword(password);

        System.out.println(person.toString());

    }
}
