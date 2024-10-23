using System.Numerics;
using System.Security.Cryptography;

Console.Write("Number of Plays?");
int NumPlays = int.Parse(Console.ReadLine());
int Player1 = 0, Player2 = 0;
int[] Resume = new int[NumPlays];


for (int i = 0; i < NumPlays; i++)
{
    int randomValueBetween0and99 = new Random().Next(0, 100);

    GameElement player1Element = null;
    GameElement player2Element = null;
    Console.WriteLine("Player 1 Playing");


    if (randomValueBetween0and99 < 31)
    {
        Console.WriteLine("Choose [1]Rock  [2]Paper  [3]Scissors  [4]SpecialPaper");
        while (Player1 != 1 && Player1 != 2 && Player1 != 3 && Player1 != 4)
        {
            Player1 = int.Parse(Console.ReadLine());

            if (Player1 != 1 && Player1 != 2 && Player1 != 3 && Player1 != 4)
            {
                Console.WriteLine("Invalid Option");
            }
        }
        if (Player1 == 1)
        {
            player1Element = new Rock("Player1");
        }
        else if (Player1 == 2)
        {
            player1Element = new Paper("Player1");
        }
        else if (Player1 == 3)
        {
            player1Element = new Scissors("Player1");
        }
        else if (Player1 == 4)
        {
            player1Element = new SpecialPaper("Player1");
        }
    }
    else
    {
        Console.WriteLine("Choose [1]Rock  [2]Paper  [3]Scissors");
        while (Player1 != 1 && Player1 != 2 && Player1 != 3)
        {
            Player1 = int.Parse(Console.ReadLine());

            if (Player1 != 1 && Player1 != 2 && Player1 != 3)
            {
                Console.WriteLine("Invalid Option");
            }
        }
        if (Player1 == 1)
        {
            player1Element = new Rock("Player1");
        }
        else if (Player1 == 2)
        {
            player1Element = new Paper("Player1");
        }
        else if (Player1 == 3)
        {
            player1Element = new Scissors("Player1");
        }

    }


    Console.WriteLine("Player 2 Playing");

    if (randomValueBetween0and99 > 69)
    {
        Console.WriteLine("Choose [1]Rock  [2]Paper  [3]Scissors  [4]SpecialPaper");
        while (Player2 != 1 && Player2 != 2 && Player2 != 3 && Player2 != 4)
        {
            Player2 = int.Parse(Console.ReadLine());

            if (Player2 != 1 && Player2 != 2 && Player2 != 3 && Player2 != 4)
            {
                Console.WriteLine("Invalid Option");
            }
        }
        if (Player2 == 1)
        {
            player1Element = new Rock("Player2");
        }
        else if (Player2 == 2)
        {
            player1Element = new Paper("Player2");
        }
        else if (Player2 == 3)
        {
            player1Element = new Scissors("Player2");
        }
        else if (Player2 == 4)
        {
            player2Element = new SpecialPaper("Player2");
        }
    }
    else
    {
        Console.WriteLine("Choose [1]Rock  [2]Paper  [3]Scissors");
        while (Player2 != 1 && Player2 != 2 && Player2 != 3)
        {
            Player2 = int.Parse(Console.ReadLine());
            if (Player2 != 1 && Player2 != 2 && Player2 != 3)
            {
                Console.WriteLine("Invalid Option");
            }
        }

        if (Player2 == 1)
        {
            player2Element = new Rock("Player2");
        }
        else if (Player2 == 2)
        {
            player2Element = new Paper("Player2");
        }
        else if (Player2 == 3)
        {
            player2Element = new Scissors("Player2");
        }
    }



    if (player1Element.Draw(player2Element))
    {
        Console.WriteLine("It's a draw!");
        Resume[i] = 0;
    }
    else if (player1Element.Defeat(player2Element))
    {
        Console.WriteLine($"{player1Element.Player} wins with {player1Element.Element}!");
        Resume[i] = 1;
    }
    else
    {
        Console.WriteLine($"{player2Element.Player} wins with {player2Element.Element}!");
        Resume[i] = 2;
    }

    //next round reset
    Player1 = 0;
    Player2 = 0;

}

Console.WriteLine("GAME RESUME");
for (int j = 0; j < Resume.Length; j++)
{
    if (Resume[j] == 0)
    {
        Console.WriteLine("[0 | 0]");
    }
    else if (Resume[j] == 1)
    {
        Console.WriteLine("[1 | 0]");
    }
    else
    {
        Console.WriteLine("[0 | 1]");
    }
}


