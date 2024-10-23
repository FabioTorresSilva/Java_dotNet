namespace FP01CSharp
{
    internal class BankAccount
    {

        public BankAccount(string accountHolder, double balance)
        {
            this.AccountHolder = accountHolder;
            this.Balance = balance;
        }

        public string AccountHolder { get; set; }

        public double Balance { get; private set; }

        public override string ToString()
        {
            return $"Conta do {AccountHolder} possui o saldo de {Balance}.";
        }

        public string Deposit(double deposit)
        {
            Balance = Balance + deposit;
            return $"Foram depositados {deposit}, novo saldo {Balance}";
        }

        public string Withdraw(double amount)
        {
            if (Balance - amount < 0)
            {
                return $"Fundos insuficientes {Balance}";
            }
            Balance -= amount;
            return $"Valor {amount} retirado, novo saldo {Balance}";
        }

        //TRANSFER money to anotherAccount
        public string Transfer(BankAccount anotherBankAccount, double value)
        {
            if (Balance - value < 0)
            {
                return $"Fundos insuficientes {Balance}";
            }
            Balance -= value;
            anotherBankAccount.Balance += value;
            return $"Valor {value} transferido para {anotherBankAccount}";
        }

        public string PrintBalance()
        {
            return $"Titular {AccountHolder} saldo da conta {Balance}";
        }

    }
}
