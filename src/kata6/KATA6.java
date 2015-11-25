package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA6 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        String nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA6-1\\emails.txt";
        
        ArrayList<Person> mailArray = MailListReader.reader(nameFile);
        ArrayList<Person1> lista = PersonLoader.read();
        
        HistogramBuilder<Person> builder = new HistogramBuilder(mailArray);
        HistogramBuilder<Person1> builder1 = new HistogramBuilder(lista);
        
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
            
        Histogram<String> domains1 = builder1.build(new Atributo<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });        
        Histogram<Float> pesos = builder1.build(new Atributo<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        
        
        
        //Histogram<String> histo = MailHistogramBuilder.build(mailArray);
        //new HistogramDisplay(histo).execute();
        new HistogramDisplay(domains,"DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
        
        new HistogramDisplay(domains1, "DOMINIOS").execute();
        new HistogramDisplay(pesos, "PESOS").execute();
        System.out.println("Fin");
    }
}
