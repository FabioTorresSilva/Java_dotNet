package org.upskill.figuras_comparator;

import java.util.Comparator;

public  class Criterio2  implements Comparator {
    public int compare(Object f1, Object f2) {
        double area1 = ((Figura)f1).calcularArea();
        double area2 = ((Figura)f2).calcularArea();

        if (area1 > area2) {
            return -1;
        } else if (area1 < area2) {
            return 1;
        } else {
            return 0;
        }
    }
}

