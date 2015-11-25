package kata6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MailListReader {
    public static ArrayList<Person> reader (String name) throws FileNotFoundException, IOException {
        ArrayList<Person> mailList = new ArrayList<>();
        BufferedReader read = new BufferedReader(new FileReader(new File(name)));
        String mail;
        Integer id = 0;
        while((mail = read.readLine()) != null) {
            if(mail.contains("@")) {
                //mailList.add(mail);
                mailList.add(new Person(id++, mail));
            }      
        }
        return mailList;
    }
}
