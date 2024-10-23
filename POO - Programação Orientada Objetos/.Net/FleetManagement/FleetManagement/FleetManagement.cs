
class FleetManager
{

    private const int MaxVehicles = 10;
    public Veiculo[] veiculos;
    private int vehicleCount;

    public FleetManager()
    {
        veiculos = new Veiculo[MaxVehicles];
        vehicleCount = 0;

    }

    public bool AddVehicle(Veiculo veiculo)
    {
        if (vehicleCount == MaxVehicles)
        {
            return false;
        }
        else
        {
            veiculos[vehicleCount++] = veiculo;
            return true;
        }
    }

    public void DisplayAllVehicles()
    {
        for (int i = 0; i < vehicleCount; i++)
        {
            veiculos[i].DisplayVehicleInfo();
        }
    }
}






