
namespace FP_11_2 {
    internal interface IAgenciaViagens {
        List<Cliente> Clientes { get; }

        void ListarClientes();
        Cliente? ProcurarCliente(Cliente cliente);
        Cliente? ProcurarCliente(string nome);
        void RegistrarCliente(Cliente cliente);
        bool RemoverCliente(Cliente cliente);
        bool RemoverCliente(string nome);
        string ToString();
    }
}