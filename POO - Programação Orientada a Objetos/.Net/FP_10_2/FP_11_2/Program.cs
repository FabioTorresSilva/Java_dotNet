namespace FP_11_2;
internal static class Program {
    private static void Main() {
        AgenciaViagens agencia = new AgenciaViagens();

        Cliente cliente1 = new Cliente { Nome = "João Silva", Email = "joao.silva@email.com" };
        Cliente cliente2 = new Cliente { Nome = "Maria Santos", Email = "maria@gmail.com" };

        agencia.RegistrarCliente(cliente1);
        agencia.RegistrarCliente(cliente2);

        agencia.ListarClientes();

        Reserva reserva1 = new Reserva {
            CodigoReserva = 1,
            Destino = Destino.Lisboa,
            TipoTransporte = TipoTransporte.Aviao,
            DataViagem = DateTime.Now.AddDays(10)
        };
        cliente1.AdicionarReserva(reserva1);

        Cliente? clienteEncontrado = agencia.ProcurarCliente("João Silva");
        if (clienteEncontrado != null) {
            clienteEncontrado.ListarReservas();
            clienteEncontrado.RemoverReserva(1);
            clienteEncontrado.ListarReservas();

        }

    }
}