
namespace FP_11_2 {
    internal interface ICliente {
        string? Email { get; set; }
        string? Nome { get; set; }
        List<Reserva> Reservas { get; }

        void AdicionarReserva(Reserva reserva);
        bool AtualizarReserva(int codigoReserva, Destino novoDestino, TipoTransporte novoTransporte, DateTime novaDataViagem);
        bool Equals(object? obj);
        int GetHashCode();
        void ListarReservas();
        bool RemoverReserva(int codigoReserva);
        bool RemoverReserva2(int codigoReserva);
        string? ToString();
    }
}