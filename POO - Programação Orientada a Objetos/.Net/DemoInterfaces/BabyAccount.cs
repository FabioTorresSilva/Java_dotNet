using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using demo.interfaces;

namespace demo
{
    /// <summary>
    /// Classe que representa uma conta de um cliente específica, neste caso para um bébé
    /// </summary>
    public class BabyAccount : Account, IBabyAccount
    {
        ///Nome do pai ou da mãe
        private string parentName;

        /// <summary>
        /// Construtor da classe BabyAccount
        /// </summary>
        public BabyAccount(AccountState state, string name, int accountNumber, string parentName) : base(state, name, accountNumber) { 
            this.parentName = parentName;
        }

        /// <summary>
        /// Método que permite levantar dinheiro da conta
        /// </summary>
        /// <param name="amount">Valor a levantar</param>
        /// <returns>true se foi possível levantar o dinheiro, caso contrário false</returns>
        public override bool WithdrawFunds(decimal amount)
        {
            if (amount > 10)
            {
                return false;
            }
            if (Balance < amount)
            {
                return false;
            }
            Balance = Balance - amount;
            return true;
        }

        public string GetParentName()
        {
            return parentName;
        }
    }
}