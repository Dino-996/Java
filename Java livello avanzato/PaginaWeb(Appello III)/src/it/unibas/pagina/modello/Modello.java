package it.unibas.pagina.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private final Map<String, Object> beans = new HashMap<>();

    public Object getBean(String chiave) {
        return beans.get(chiave);
    }

    public void putBean(String chiave, Object valore) {
        beans.put(chiave, valore);
    }
}
