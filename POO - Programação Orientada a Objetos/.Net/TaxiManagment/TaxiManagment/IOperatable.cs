namespace TaxiManagment {
    public interface IOperatable {
        bool IsRunning { get; }
        void Start();
        void Stop();
    }
}
