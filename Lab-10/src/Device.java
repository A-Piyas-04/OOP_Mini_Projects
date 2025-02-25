public interface Device {
    void turnOn();
    void turnOff();
    boolean isOn();
    String getLocation();
    void setLocation(String location);
}