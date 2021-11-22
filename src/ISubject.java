public interface ISubject {

    void attach(IObserver obj);
    void detach(IObserver obj);
    void notifyObservers(Enum o, int num);

}