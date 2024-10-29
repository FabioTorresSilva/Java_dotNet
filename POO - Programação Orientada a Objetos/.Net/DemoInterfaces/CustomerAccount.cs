using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using demo.interfaces;

namespace demo
{
    /// <summary>
    /// Classe que representa uma conta de um cliente
    /// </summary>
    public class CustomerAccount : Account, ICustomerAccount
    {
        public string job { get; set; }
        /// <summary>
        /// Construtor da classe CustomerAccount
        /// </summary>
        public CustomerAccount(string job, AccountState state, string name, int accountNumber) : base(state, name, accountNumber)
        {
            this.job = job;
        }

        /// <summary>
        /// Método que permite levantar dinheiro da conta
        /// </summary>
        /// <param name="amount">Valor a levantar</param>
        /// <returns>true se foi possível levantar o dinheiro, caso contrário false</returns>
        public override bool WithdrawFunds(decimal amount)
        {
            if (Balance < amount)
            {
                return false;
            }
            Balance = Balance - amount;
            return true;
        }

        public string GetJob()
        {
            return job;
        }
    }
}