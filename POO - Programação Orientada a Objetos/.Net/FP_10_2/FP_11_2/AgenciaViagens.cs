using System.Text;

namespace FP_11_2 {
    internal class AgenciaViagens : IAgenciaViagens {
        public List<Cliente> Clientes { get; } = new List<Cliente>();

        public void RegistrarCliente(Cliente cliente) {
            Clientes.Add(cliente);
        }

        public Cliente? ProcurarCliente(string nome) {
            for (int i = 0; i < Clientes.Count; i++) {
                if (Clientes[i] != null && nome.Equals(Clientes[i].Nome, StringComparison.OrdinalIgnoreCase)) {
                    return Clientes[i];
                }
            }
            return null;
        }

        public Cliente? ProcurarCliente(Cliente cliente) {
            for (int i = 0; i < Clientes.Count; i++) {
                if (Clientes[i] != null && Clientes[i].Equals(cliente)) {
                    return Clientes[i];
                }
            }
            return null;
        }

        public bool RemoverCliente(string nome) {
            Cliente? cliente = ProcurarCliente(nome);
            if (cliente == null) {
                return false;
            }

            Clientes.Remove(cliente);
            return true;
        }

        public bool RemoverCliente(Cliente cliente) {
            Cliente? clienteEncontrado = ProcurarCliente(cliente);
            if (clienteEncontrado == null) {
                return false;
            }

            Clientes.Remove(clienteEncontrado);
            return true;
        }

        public void ListarClientes() {
            Console.WriteLine("Lista de Clientes:");
            foreach (var cliente in Clientes) {
                Console.WriteLine($"Cliente: {cliente.Nome}, Email: {cliente.Email}");
                cliente.ListarReservas();
            }
        }

        public override string ToString() {
            StringBuilder res = new StringBuilder();
            res.AppendLine("Lista de Clientes:");
            foreach (var cliente in Clientes) {
                res.AppendLine($"Cliente: {cliente.Nome}, Email: {cliente.Email}");
                res.AppendLine(cliente.ToString());
            }
            return res.ToString();
        }
    }
}
