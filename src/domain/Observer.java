package domain;

public interface Observer {
    public void update(EventType eventType, Account account);
}
