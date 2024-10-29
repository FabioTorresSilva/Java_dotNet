namespace ficha7.interfaces
{
    public interface IServicoBombaGasolina
    {
        /// <summary>
        /// Retorna o preço do combustível
        /// </summary>
        /// <param name="tipoCombustivel">G- Gasolina, D-Diesel</param>
        /// <returns></returns>
        float GetPrecoCombustivel(string tipoCombustivel);
    }
}