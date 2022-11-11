package it.unibas.file.persistenza;

import it.unibas.file.modello.Archivio;
import it.unibas.file.modello.Cartella;
import it.unibas.file.modello.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String files) throws DAOException {
        Archivio archivio = new Archivio();

        Cartella cartella = new Cartella("C:/Users/Davide/giochi", new GregorianCalendar(2022, Calendar.AUGUST, 16, 10, 11, 40), "Davide");
        File file = new File("Call Of Duty Warzone.exe", 108, new GregorianCalendar(2022, Calendar.AUGUST, 18, 14, 50));
        File file1 = new File("Spiderman:Remastered.exe", 62, new GregorianCalendar(2022, Calendar.AUGUST, 24, 11, 00));
        File file2 = new File("Total War Warhammer 3.exe", 70, new GregorianCalendar(2022, Calendar.AUGUST, 21, 21, 35));
        
        Cartella cartella1 = new Cartella("C:/Users/Davide/programmi", new GregorianCalendar(2022, Calendar.AUGUST, 18, 20, 30), "Davide");
        File file3 = new File("Visual Studio.exe", 640, new GregorianCalendar(2022, Calendar.AUGUST, 27, 10, 10));
        File file4 = new File("NetBeans.exe", 47, new GregorianCalendar(2022, Calendar.AUGUST, 30, 13, 45));
        File file8 = new File("Adobe Lightroom.exe", 12, new GregorianCalendar(2022, Calendar.AUGUST, 31, 18, 35));
        File file9 = new File("Adobe Photoshop.exe", 3, new GregorianCalendar(2022, Calendar.AUGUST, 31, 18, 35));
        File file10 = new File("Steam.dll", 2, new GregorianCalendar(2022, Calendar.AUGUST, 20, 11, 37));
        
        Cartella cartella2 = new Cartella("C:/Users/Valerio/documenti", new GregorianCalendar(2022, Calendar.AUGUST, 21, 12, 50), "Valerio");
        File file5 = new File("Appunti.txt", 39, new GregorianCalendar(2022, Calendar.AUGUST, 24, 10, 21));
        File file6 = new File("Library.dll", 27, new GregorianCalendar(2022, Calendar.AUGUST, 25, 16, 28));
        File file7 = new File("File.doc", 1, new GregorianCalendar(2022, Calendar.AUGUST, 25, 16, 28));
        
        cartella.addFile(file);
        cartella.addFile(file1);
        cartella.addFile(file2);
        
        cartella1.addFile(file3);
        cartella1.addFile(file4);
        cartella1.addFile(file8);
        cartella1.addFile(file9);
        cartella1.addFile(file10);
        
        cartella2.addFile(file5);
        cartella2.addFile(file6);
        cartella2.addFile(file7);
        
        archivio.addCartella(cartella);
        archivio.addCartella(cartella1);
        archivio.addCartella(cartella2);
        
        return archivio;
    }  
}
