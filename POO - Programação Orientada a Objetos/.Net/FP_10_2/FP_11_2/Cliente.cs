using System.Text;

namespace FP_11_2
{
    internal class Cliente : ICliente
    {
        public string? Nome { get; set; }
        public string? Email { get; set; }
        public List<Reserva> Reservas { get; } = new List<Reserva>();

        public void AdicionarReserva(Reserva reserva)
        {
            Reservas.Add(reserva);
        }

        private Reserva? ProcurarReserva(int codigoReserva)
        {
            for (int i = 0; i < Reservas.Count; i++)
            {
                if (Reservas[i].CodigoReserva == codigoReserva)
                {
                    return Reservas[i];
                }
            }
            return null;
        }

        private int? ObterPosicaoReserva(int codigoReserva)
        {
            for (int i = 0; i < Reservas.Count; i++)
            {
                if (Reservas[i].CodigoReserva == codigoReserva)
                {
                    return i;
                }
            }
            return null;

        }

        public bool RemoverReserva(int codigoReserva)
        {
            int? pos = ObterPosicaoReserva(codigoReserva);

            if (pos == null)
            {
                return false;
            }

            Reservas.RemoveAt((int)pos);
            return true;
        }

        public bool RemoverReserva2(int codigoReserva)
        {
            Reserva? reserva = ProcurarReserva(codigoReserva);

            return (reserva != null) && Reservas.Remove(reserva);
        }

        public bool AtualizarReserva(int codigoReserva, Destino novoDestino, TipoTransporte novoTransporte, DateTime novaDataViagem)
        {
            Reserva? reserva = ProcurarReserva(codigoReserva);

            if (reserva == null)
            {
                return false;
            }

            reserva.Destino = novoDestino;
            reserva.TipoTransporte = novoTransporte;
            reserva.DataViagem = novaDataViagem;

            return true;
        }

        public void ListarReservas()
        {
            Console.WriteLine($"Reservas para o cliente {Nome}:");
            foreach (var reserva in Reservas)
            {
                Console.WriteLine(reserva);
            }
        }

        public override string? ToString()
        {
            StringBuilder res = new StringBuilder($"Cliente: {Nome}, Email: {Email}");

            res.Append("\nReservas:");
            foreach (var reserva in Reservas)
            {
                res.Append($"\n{reserva.CodigoReserva} - {reserva.Destino} - {reserva.TipoTransporte} - {reserva.DataViagem.ToShortDateString()}");
            }

            return res.ToString();
        }

        public override bool Equals(object? obj)
        {
            return obj is Cliente cliente &&
                   Nome == cliente.Nome &&
                   Email == cliente.Email;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(Nome, Email);
        }
    }
}
