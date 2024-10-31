package exposicao;

import java.util.Comparator;

public class AlfabAutorAlfabDesig implements Comparator<Quadro> {
    public int compare(Quadro f1, Quadro f2) {

        if (f1.getAutor().compareToIgnoreCase(f2.getAutor()) < 0)
            return -1;
        else if (f1.getAutor().compareToIgnoreCase(f2.getAutor()) > 0)
            return 1;
        else
            return f1.getDesignacao().compareToIgnoreCase(f2.getDesignacao());
    }
}
