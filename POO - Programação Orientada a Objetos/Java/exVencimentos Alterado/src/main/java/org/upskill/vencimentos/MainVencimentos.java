package org.upskill.vencimentos;

import java.util.ArrayList;
import java.util.List;

public class MainVencimentos {

    public static void main(String[] args) {
        
        Empresa minhaEmpresa = new Empresa("Wave", "Rua Canico");
        Trabalhador trabalhadorPeca = new TrabalhadorPeca("Jorge ", 22, 30);
        Trabalhador trabalhadorPeca1 = new TrabalhadorPeca("Silva", 23, 33);
        Trabalhador trabalhadorComissao = new TrabalhadorComissao("Susana ", 500.0f, 1500.0f, 6f, 321);
        Trabalhador trabalhadorComissao1 = new TrabalhadorComissao("Ferreira ", 500.0f, 1500.0f, 6f, 321);
        Trabalhador trabalhadorHora = new TrabalhadorHora("Carlos", 160, 10);
        Trabalhador trabalhadorHora1 = new TrabalhadorHora("Manel", 160, 10);

        minhaEmpresa.adicionarTrabalhador(trabalhadorPeca);
        minhaEmpresa.adicionarTrabalhador(trabalhadorPeca1);
        minhaEmpresa.adicionarTrabalhador(trabalhadorComissao);
        minhaEmpresa.adicionarTrabalhador(trabalhadorComissao1);
        minhaEmpresa.adicionarTrabalhador(trabalhadorHora);
        minhaEmpresa.adicionarTrabalhador(trabalhadorHora1);

        minhaEmpresa.listarTrabalhadoresPorTipo(TrabalhadorComissao.class);
        minhaEmpresa.listarTrabalhadoresPorTipo(TrabalhadorHora.class);
        minhaEmpresa.listarTrabalhadoresPorTipo(TrabalhadorPeca.class);
    }
}