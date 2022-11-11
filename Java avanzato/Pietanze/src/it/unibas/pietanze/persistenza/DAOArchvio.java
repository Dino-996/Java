package it.unibas.pietanze.persistenza;

import it.unibas.pietanze.modello.Archivio;
import it.unibas.pietanze.modello.Costanti;
import it.unibas.pietanze.modello.Ingrediente;
import it.unibas.pietanze.modello.Pietanza;

public class DAOArchvio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        //INGREDIENTI PER ANTIPASTO
        Ingrediente salumi = new Ingrediente("SALUMI", 4, true, 10);
        Ingrediente insalata = new Ingrediente("INSALATA", 6.8, false, 3);
        Ingrediente fruttiDiMare = new Ingrediente("FRUTTI DI MARE", 3.5, false, 2);
        //INGREDIENTI PER PRIMO
        Ingrediente pasta = new Ingrediente("PASTA", 30, false, 2);
        Ingrediente tonno = new Ingrediente("TONNO", 5.0, true, 3);
        Ingrediente pesto = new Ingrediente("PESTO", 3.0, true, 2);
        //INGREDIENTI PER SECONDO
        Ingrediente tacchino = new Ingrediente("CARNE DI TACCHINO", 3.2, false, 2);
        Ingrediente pollo = new Ingrediente("CARNE DI POLLO", 5.8, false, 2);
        Ingrediente manzo = new Ingrediente("CARNE DI MANZO", 7.3, true, 4);
        //INGREDIENTI PER DESSERT
        Ingrediente nocciola = new Ingrediente("NOCCIOLA", 6.0, true, 10);
        Ingrediente cioccolato = new Ingrediente("CIOCCOLATO", 4.9, true, 25);
        
        //ANTIPASTI
        Pietanza antipastoDiSalumi = new Pietanza("ANTIPASTO DI SALUMI", 8, Costanti.CATEGORIA_ANTIPASTO);
        antipastoDiSalumi.addIngrediente(salumi);
        
        Pietanza insalataAiFruttiDiMare = new Pietanza("ANTIPASTO AI FRUTTI DI MARE", 14, Costanti.CATEGORIA_ANTIPASTO);
        insalataAiFruttiDiMare.addIngrediente(insalata);
        insalataAiFruttiDiMare.addIngrediente(fruttiDiMare);
        
        //PRIMI
        Pietanza pastaAlTonno = new Pietanza("PASTA AL TONNO", 10, Costanti.CATEGORIA_PRIMO);
        pastaAlTonno.addIngrediente(pasta);
        pastaAlTonno.addIngrediente(tonno);
        
        Pietanza pastaAlPesto = new Pietanza("PASTA AL PESTO", 12, Costanti.CATEGORIA_PRIMO);
        pastaAlPesto.addIngrediente(pasta);
        pastaAlPesto.addIngrediente(pesto);
        
        //SECONDI
        Pietanza manzoAffumicato = new Pietanza("MANZO AFFUMICATO", 13, Costanti.CATEGORIA_SECONDO);
        manzoAffumicato.addIngrediente(manzo);
        
        Pietanza polloArrosto = new Pietanza("POLLO ARROSTO", 10, Costanti.CATEGORIA_SECONDO);
        polloArrosto.addIngrediente(pollo);
        
        Pietanza tacchinoAiFerri = new Pietanza("TACCHINO AI FERRI", 15, Costanti.CATEGORIA_SECONDO);
        tacchinoAiFerri.addIngrediente(tacchino);
        
        //DESSERT
        Pietanza tortaNocciolaECioccolato = new Pietanza("TORTA NOCCIOLA E CIOCCOLATO", 9, Costanti.CATEGORIA_DESSERT);
        tortaNocciolaECioccolato.addIngrediente(nocciola);
        tortaNocciolaECioccolato.addIngrediente(cioccolato);

        archivio.addPietanza(antipastoDiSalumi);
        archivio.addPietanza(insalataAiFruttiDiMare);
        archivio.addPietanza(pastaAlTonno);
        archivio.addPietanza(pastaAlPesto);
        archivio.addPietanza(manzoAffumicato);
        archivio.addPietanza(polloArrosto);
        archivio.addPietanza(tacchinoAiFerri);
        archivio.addPietanza(tortaNocciolaECioccolato);
        
        return archivio;
    }
}
