namespace FP01CSharp
{
    internal class Data
    {

        private int ano;
        private int mes;
        private int dia;

        private static readonly int ANO_POR_OMISSAO = 1;
        private static readonly int MES_POR_OMISSAO = 1;
        private static readonly int DIA_POR_OMISSAO = 1;

        private static readonly string[] nomeDiaDaSemana = { "Domingo", "Segunda-feira",
        "Terça-feira", "Quarta-feira",
        "Quinta-feira", "Sexta-feira",
        "Sábado" };

        private static readonly int[] diasPorMes = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
        31, 30, 31 };

        private static readonly string[] nomeMes = { "Inválido", "Janeiro", "Fevereiro",
        "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro",
        "Outubro", "Novembro", "Dezembro" };

        public Data(int ano, int mes, int dia)
        {
            this.ano = ano;
            this.mes = mes;
            this.dia = dia;
        }

        public Data()
        {
            ano = ANO_POR_OMISSAO;
            mes = MES_POR_OMISSAO;
            dia = DIA_POR_OMISSAO;
        }

        public int Ano
        {
            get { return ano; }
        }

        public int Mes
        {
            get { return mes; }
        }

        public int Dia
        {
            get { return dia; }
        }

        public void SetData(int ano, int mes, int dia)
        {
            this.ano = ano;
            this.mes = mes;
            this.dia = dia;
        }

        public override string ToString()
        {
            return DeterminarDiaDaSemana() + ", " + dia + " de " + nomeMes[mes] + " de " + ano;
        }

        public string ToAnoMesDiaString()
        {
            return $"{ano:D4}/{mes:D2}/{dia:D2}";
        }

        public string DeterminarDiaDaSemana()
        {
            int totalDias = ContarDias();
            totalDias = totalDias % 7;

            return nomeDiaDaSemana[totalDias];
        }

        public bool IsMaior(Data outraData)
        {
            int totalDias = ContarDias();
            int totalDias1 = outraData.ContarDias();

            return totalDias > totalDias1;
        }

        public int CalcularDiferenca(Data outraData)
        {
            int totalDias = ContarDias();
            int totalDias1 = outraData.ContarDias();

            return Math.Abs(totalDias - totalDias1);
        }

        public int CalcularDiferenca(int ano, int mes, int dia)
        {
            int totalDias = ContarDias();
            Data outraData = new Data(ano, mes, dia);
            int totalDias1 = outraData.ContarDias();

            return Math.Abs(totalDias - totalDias1);
        }

        public static bool IsAnoBissexto(int ano)
        {
            return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
        }

        private int ContarDias()
        {
            int totalDias = 0;

            for (int i = 1; i < ano; i++)
            {
                totalDias += IsAnoBissexto(i) ? 366 : 365;
            }
            for (int i = 1; i < mes; i++)
            {
                totalDias += diasPorMes[i];
            }
            totalDias += (IsAnoBissexto(ano) && mes > 2) ? 1 : 0;
            totalDias += dia;

            return totalDias;
        }

    }
}
