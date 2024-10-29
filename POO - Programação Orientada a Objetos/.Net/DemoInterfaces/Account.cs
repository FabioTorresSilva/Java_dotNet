using System.Dynamic;
using System.Text;
using demo.interfaces;

namespace demo;


/// <summary>
/// Classe que representa uma conta de um cliente
/// </summary>
public abstract class Account : IAccount, IPrintToPaper
{
    /// Estados possíveis de uma conta
    public AccountState State { get; set; }
    /// Nome do cliente
    public string? Name { get; set; }

    ///Número da conta
    public int AccountNumber { get; }
    ///Saldo da conta
    public decimal Balance { protected set; get; } = 0;

    /// <summary>
    /// Construtor da classe Account
    /// </summary>
    /// <param name="state"> Estado </param>
    /// <param name="name"> Nome do cliente</param>
    /// <param name="accountNumber">Número da conta</param>
    public Account(AccountState state, string name, int accountNumber)
    {
        this.State = state;
        this.Name = name;
        this.AccountNumber = accountNumber;
    }

    public abstract bool WithdrawFunds(decimal amount);

    /// <summary>
    /// Método abstrato para depositar dinheiro
    /// </summary>
    public void Deposit(decimal amount)
    {
        Balance = Balance + amount;
    }

    /// <summary>
    /// Método que devolve o saldo da conta
    /// </summary>
    public decimal GetBalance()
    {
        return Balance;
    }

    /// <summary>
    /// Método que devolve uma representação em string da conta
    /// </summary>
    public override string ToString()
    {
        return "Name: " + this.Name + " balance: " + this.Balance;
    }

    /// <summary>
    /// Método que compara duas contas
    /// </summary>
    public override bool Equals(object? obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (obj is not Account)
        {
            return false;
        }

        Account a = (Account)obj;
        if (a.AccountNumber != this.AccountNumber)
        {
            return false;
        }

        return true;
    }

    public override int GetHashCode()
    {
        return HashCode.Combine(AccountNumber, Name, State, Balance);
    }


    public void Doprint()
    {
        StringBuilder stringBuilder = new StringBuilder();

        // ASCII art header
        stringBuilder.AppendLine(@"   _____                                  _____              .___   _________           .__                      
                                    /     \   ____   ____   ____ ___.__.   /  _  \   ____    __| _/  /   _____/____ ___  _|__| ____    ____  ______
                                    /  \ /  \ /  _ \ /    \_/ __ <   |  |  /  /_\  \ /    \  / __ |   \_____  \\__  \\  \/ /  |/    \  / ___\/  ___/
                                    /    Y    (  <_> )   |  \  ___/\___  | /    |    \   |  \/ /_/ |   /        \/ __ \\   /|  |   |  \/ /_/  >___ \ 
                                    \____|__  /\____/|___|  /\___  > ____| \____|__  /___|  /\____ |  /_______  (____  /\_/ |__|___|  /\___  /____  >
                                            \/            \/     \/\/              \/     \/      \/          \/     \/             \//_____/     \/ ");

        // Account details
        stringBuilder.AppendLine($"Account Holder: {this.Name}");
        stringBuilder.AppendLine($"Account Number: {this.AccountNumber}");
        stringBuilder.AppendLine($"Account Balance: ${this.Balance}");

        Console.WriteLine(stringBuilder.ToString());
    }
}