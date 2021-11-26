public interface ISubject {

    void attach(IObserver obj);
    void detach(IObserver obj);
    void notifyObservers();
    void notifyObservers(Enum o, int i);

}