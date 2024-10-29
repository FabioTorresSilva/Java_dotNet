using demo.interfaces;

namespace demo;

///<summary>
///  O objetivo deste exemplo passa por gerir contas de um banco.
///  É necessário guardar informações sobre clientes, que incluem nome, endereço, número da conta, saldo e valor do cheque especial.
///  Outros itens poderão ser adicionados posteriormente.Existem vários clientes e existem também vários tipos diferentes de contas
/// </summary>
class Program
{
    static void Main(string[] args)
    {
        IAccount account1 = new CustomerAccount("Developer", AccountState.New, "Bruno", 123);
        IAccount account2 = new CustomerAccount("Professor", AccountState.New, "João", 122);
        IAccount account3 = new BabyAccount(AccountState.New, "Sara", 111, "Bruno");

        IBank bank = new Bank();

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        foreach (IAccount account in bank.GetAccounts())
        {
            if (account is IPrintToPaper)
            {
                IPrintToPaper printToPaper = (IPrintToPaper)account;
                printToPaper.Doprint();
            }
        }

    }
}
