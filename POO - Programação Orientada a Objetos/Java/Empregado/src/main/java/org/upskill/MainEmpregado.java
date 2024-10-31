package org.upskill;

import org.upskill.utils.Data;
import org.upskill.utils.Tempo;

import java.util.ArrayList;
import java.util.List;

public class MainEmpregado {
    public static void main(String[] args) {

        Data d = Data.dataAtual();
        System.out.println("Data d = " + d.toAnoMesDiaString());

        Tempo t1 = new Tempo(14, 0);
        System.out.println("Tempo t1 = " + t1.toStringHHMMSS());

        Tempo t2 = new Tempo(19, 30);
        System.out.println("Tempo t2 = " + t2.toStringHHMMSS());

        Empregado e1 = new Empregado("Manuel", "Silva", d, t1, t2);
        Empregado e2 = new Empregado("Miguel", "Ferreira", d, t1, t2);


        e1.setDataContrato(2015, 1, 1);
        System.out.println(e1.toString());
        System.out.println(e2.toString());

        e1.setHoraEntrada(new Tempo(13, 00));
        System.out.println(e1.toString());
        System.out.println(e2.toString());

        e1.setHoraSaida(new Tempo(18, 30));
        System.out.println(e1.toString());
        System.out.println(e2.toString());

        System.out.println();
        d.setData(2015, 9, 11);
        System.out.println("Data d = " + d.toAnoMesDiaString());
        t1.setTempo(17, 0, 0);
        System.out.println("Tempo t1 = " + t1.toStringHHMMSS());
        t2.setTempo(23, 0, 0);
        System.out.println("Tempo t2 = " + t2.toStringHHMMSS());

        System.out.println(e1.toString());
        System.out.println(e2.toString());

        e2.setDataContrato(new Data(2000, 1, 1));
        e2.setHoraEntrada(new Tempo(8, 0));
        e2.setHoraSaida(new Tempo(12, 0));

        List<Empregado> empregados = new ArrayList<>();
        empregados.add(e1);
        empregados.add(e2);

        for (Empregado empregado : empregados) {
            if (empregado != null) {
                System.out.println(empregado.toString());
            }
        }

        for (Empregado empregado : empregados) {
            if (empregado != null) {
                System.out.printf("%s %s trabalha %.1f horas por semana e foi contratado há %s %n",
                        empregado.getPrimeiroNome(),
                        empregado.getUltimoNome(),
                        empregado.calcularHorasTrabalhoSemanal(),
                        empregado.tempoContratado());
            }
        }
    }
}
