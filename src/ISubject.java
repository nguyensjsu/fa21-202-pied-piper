public interface ISubject {

    public abstract void attach(IObserver obj);
    public abstract void detach(IObserver obj);
    public abstract void notifyObservers();

}