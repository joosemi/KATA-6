package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class KATA6 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA6-1\\emails.txt";
        ArrayList<Person> mailArray = MailListReader.reader(nameFile);
        
        HistogramBuilder<Person> builder = new HistogramBuilder(mailArray);
        
        Histogram<String> domains = builder.build(new Atributo<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
         Histogram<Character> letters = builder.build(new Atributo<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
            
        
        
        //Histogram<String> histo = MailHistogramBuilder.build(mailArray);
        //new HistogramDisplay(histo).execute();
        new HistogramDisplay(domains,"DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
        System.out.println("Fin");
    }
}
