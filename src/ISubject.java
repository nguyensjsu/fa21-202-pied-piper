public interface ISubject {

    void attach(IObserver obj);
    void detach(IObserver obj);
    void notifyObservers(String str, int num);

}