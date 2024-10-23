
using FP01CSharp;

BankAccount bankAccount1 = new BankAccount("Fábio", 20000);
BankAccount bankAccount2 = new BankAccount("manel", 10000);

bankAccount1.Deposit(2999);

Console.WriteLine(bankAccount1);

bankAccount1.Withdraw(2999);

bankAccount1.Withdraw(2999);

bankAccount1.Transfer(bankAccount2, 2000);
Console.WriteLine(bankAccount1);
Console.WriteLine(bankAccount2);

Console.WriteLine(bankAccount1.Withdraw(5123999));

Console.WriteLine(bankAccount1.PrintBalance());
