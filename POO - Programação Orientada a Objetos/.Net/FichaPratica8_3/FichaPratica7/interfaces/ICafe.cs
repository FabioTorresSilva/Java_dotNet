namespace ficha7.interfaces {
    public interface ICafe : IEstabelecimento, IServicoCafetaria, IServicoLoteria {
        int NumeroMesas { get; set; }
    }
}