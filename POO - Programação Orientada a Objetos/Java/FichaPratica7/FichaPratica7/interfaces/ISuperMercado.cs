namespace ficha7.interfaces
{
    public interface ISuperMercado : IEstabelecimento, IServicoCafetaria
    {
        int NumeroCorredores { get; set; }
    }
}