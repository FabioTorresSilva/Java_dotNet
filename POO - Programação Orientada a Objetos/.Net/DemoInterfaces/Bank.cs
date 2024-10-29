using demo.interfaces;

namespace demo
{
    /// <summary>
    /// Classe que representa um banco
    /// </summary>
    public class Bank: IBank
    {
        private List<IAccount> Accounts;

        /// <summary>
        /// Construtor da classe Bank
        /// </summary>
        public Bank()
        {
            this.Accounts = new List<IAccount>();
        }

        /// <summary>
        /// Método que permite adicionar uma conta de um cliente
        /// <param name="account"/> Conta a adicionar </param>
        /// </summary>
        public bool addAccount(IAccount account)
        {
            if (account == null)
            {
                return false;
            }
            // Verificar se a conta já existe
            
            this.Accounts.Add(account);
            return true;
        }

        /// <summary>
        /// Método que permite remover uma conta de um cliente
        /// </summary>
        public bool removeAccount(IAccount account)
        {
            if (account == null)
            {
                return false;
            }
            return this.Accounts.Remove(account);
        }

        /// <summary>
        /// Método que permite verificar se uma conta existe
        /// </summary>
        /// <param name="account"> Conta a verificar </param>
        /// <returns></returns>
        public bool Contains(IAccount account)
        {
            return this.Accounts.Contains(account);
        }

        /// <summary>
        /// Método que permite obter uma conta de um cliente
        /// </summary>
        /// <param name="accountNumber">Número da conta</param>
        /// <returns></returns>
        public Account? GetAccount(int accountNumber)
        {
            foreach (Account account in this.Accounts)
            {
                if (account.AccountNumber == accountNumber)
                {
                    return account;
                }
            }
            return null;
        }

        /// <summary>
        /// Método que permite imprimir todas as contas
        /// </summary>
        public void printAccounts()
        {
            foreach (Account account in this.Accounts)
            {
                Console.WriteLine(account);
            }
        }

        public List<IAccount> GetAccounts()
        {
            return this.Accounts;
        }
    }
}