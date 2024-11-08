namespace FP_11_2 {
    internal class Reserva {
        public int CodigoReserva { get; set; }
        public Destino Destino { get; set; }
        public TipoTransporte TipoTransporte { get; set; }
        public DateTime DataViagem { get; set; }

        public override string ToString() {
            return $"Código da Reserva: {CodigoReserva}, Destino: {Destino}, Transporte: {TipoTransporte}, Data da Viagem: {DataViagem.ToShortDateString()}";
        }

    }
}
