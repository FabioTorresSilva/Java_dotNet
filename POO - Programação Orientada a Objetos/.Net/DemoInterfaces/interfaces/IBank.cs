
namespace demo.interfaces
{
    /// <summary>
    /// Classe que representa um banco
    /// </summary>
    public interface IBank
    {

        /// <summary>
        /// Método que permite adicionar uma conta de um cliente
        /// <param name="account"/> Conta a adicionar </param>
        /// </summary>
        public bool addAccount(IAccount account);

        /// <summary>
        /// Método que permite remover uma conta de um cliente
        /// </summary>
        public bool removeAccount(IAccount account);

        /// <summary>
        /// Método que permite verificar se uma conta existe
        /// </summary>
        /// <param name="account"> Conta a verificar </param>
        /// <returns></returns>
        public bool Contains(IAccount account);
        /// <summary>
        /// Método que permite obter uma conta de um cliente
        /// </summary>
        /// <param name="accountNumber">Número da conta</param>
        /// <returns></returns>
        public Account? GetAccount(int accountNumber);

        /// <summary>
        /// Método que permite imprimir todas as contas
        /// </summary>
        public void printAccounts();

        /// <summary>
        /// Método que permite obter todas as contas
        /// </summary>
        /// <returns>Uma lista de IAccount</returns>
        public List<IAccount> GetAccounts();


    }
}