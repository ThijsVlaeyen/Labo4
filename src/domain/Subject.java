package domain;

import jdk.jfr.Event;

import java.util.List;

public interface Subject {
    void registerObserver(List<EventType> list, Observer o);
    void addObserver(EventType e, Observer o);
    void removeObserver(EventType e, Observer o);
    void updateObsrvers(EventType e, Account account);
}
