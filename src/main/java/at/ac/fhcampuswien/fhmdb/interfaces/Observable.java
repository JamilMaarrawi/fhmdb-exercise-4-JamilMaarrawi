package at.ac.fhcampuswien.fhmdb.interfaces;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(boolean success);
}
