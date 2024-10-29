namespace demo.interfaces;

/// <summary>
/// Interface que representa uma conta 
/// </summary>
public interface IAccount
{
    bool WithdrawFunds(decimal amount);
    decimal GetBalance();
    void Deposit(decimal amount);
}