package net.ent.etrs.view.ihm.menus;

//import ent.etrs.pndg.ihm.Ihm;

import net.ent.etrs.view.ihm.Ihm;

import java.util.List;
import java.util.Objects;

public abstract class AbstractMenu implements Saisissable {
    public static final String LIB_QUITTER_DFLT = " Quitter";

    protected Object[] lesLibelles;
    protected String titre;

    public AbstractMenu(String titre, Object[] lesLib) throws Exception {
        setLesLibelles(lesLib);
        setTitre(titre);
    }

    public AbstractMenu(String titre, List<String> lesLib) throws Exception {
        setLesLibelles((String[]) lesLib.toArray());
        setTitre(titre);
    }

    private void setTitre(String titre) throws Exception {
        if (Objects.isNull(titre)) {
            throw new Exception("ERR: le titre vaut NULL");
        }
        this.titre = titre;
    }

    private void setLesLibelles(Object[] lesLibelles) throws Exception {
        if (Objects.isNull(lesLibelles)) {
            throw new Exception("ERR: le tableau des libelles du menu vaut NULL");
        }
        if (lesLibelles.length < 2) {
            throw new Exception("ERR: le tableau des libelles est trop petit");
        }
        this.lesLibelles = lesLibelles;
    }

    public abstract String getStrMenu();

    public abstract int saisirChoixEntierMenu(Ihm vue) throws Exception;

    public abstract char getCharFromIntChoix(int chx);

}
