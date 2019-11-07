package domain;

import jdk.jfr.Event;

import java.util.Collection;
import java.util.List;

public interface Subject {
    void registerObserver(List<EventType> list, Observer o);
    void addObserver(Collection<EventType> bankEvents, Observer observer);
    void addObserver(EventType e, Observer o);
    void removeObserver(EventType e, Observer o);
    void updateObservers(EventType e, int accountNumber);
}
