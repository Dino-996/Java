package it.unibas.pagina.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private final List<PaginaWeb> listaPagine = new ArrayList<>();

    public void addPaginaWeb(PaginaWeb paginaWeb) {
        this.listaPagine.add(paginaWeb);
    }

    public List<PaginaWeb> getListaPagine() {
        return listaPagine;
    }

    //PUNTO 2 - Utente cerca pagine web
    public List<PaginaWeb> cercaPagineWeb(String indirizzo) {
        List<PaginaWeb> listaFiltrata = new ArrayList<>();
        for (PaginaWeb paginaWeb : this.listaPagine) {
            if (paginaWeb.getIndirizzoUnivoco().contains(indirizzo)) {
                listaFiltrata.add(paginaWeb);
            }
        }
        Collections.sort(listaFiltrata);
        logger.debug("PUNTO2 - PAGINE WEB TROVATE: {}", listaFiltrata.size());
        return listaFiltrata;
    }

    //PUNTO 4 - Verifica archivio
    public PaginaWeb verificaArchivio() {
        List<PaginaWeb> pagineSelezionate = listaPagineConAnnNonAggiornate();
        PaginaWeb altraPagina = null;
        for (PaginaWeb paginaWeb : pagineSelezionate) {
            if (altraPagina == null || paginaWeb.contaColoreRosso() > altraPagina.contaColoreRosso()) {
                altraPagina = paginaWeb;
            }
        }
        logger.debug("PUNTO4 - PAGINA CON PIU ANNOTAZIONI ROSSE\n{}\nAnnotazioni rosse: {}", altraPagina, altraPagina.contaColoreRosso());
        return altraPagina;
    }

    private List<PaginaWeb> listaPagineConAnnNonAggiornate() {
        List<PaginaWeb> listaPagineNonAggiornate = new ArrayList<>();
        for (PaginaWeb paginaWeb : this.listaPagine) {
            if (paginaWeb.contieneAnnotazioniNonAggiornate(paginaWeb.getDataOraUltimoAggiornamento().getTime())) {
                listaPagineNonAggiornate.add(paginaWeb);
            }
        }
        logger.debug("PUNTO4 - PAGINE NON AGGIORNATE: {}", listaPagineNonAggiornate.size());
        return listaPagineNonAggiornate;
    }
}
