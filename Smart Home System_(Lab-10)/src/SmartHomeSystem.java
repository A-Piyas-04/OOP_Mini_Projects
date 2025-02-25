import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartHomeSystem {
    private Map< String, List<Device> > devicesByLocation;
    private List<Device> allDevices;

    public SmartHomeSystem() {
        this.devicesByLocation = new HashMap<>();
        this.allDevices = new ArrayList<>();
    }

    public void addDevice(Device device, String location) {
        device.setLocation(location);
        allDevices.add(device);
        devicesByLocation.computeIfAbsent(location, k -> new ArrayList<>()).add(device);
    }

    public void removeDevice(Device device) {
        String location = device.getLocation();
        if (location != null && devicesByLocation.containsKey(location)) {
            devicesByLocation.get(location).remove(device);
            if (devicesByLocation.get(location).isEmpty()) {
                devicesByLocation.remove(location);
            }
        }
        allDevices.remove(device);
    }

    public List<Device> getDevicesByLocation(String location) {
        return devicesByLocation.getOrDefault(location, new ArrayList<>());
    }

    public List<Device> getAllDevices() {
        return new ArrayList<>(allDevices);
    }

    public void turnOnAllDevices() {
        allDevices.forEach(Device::turnOn);
    }

    public void turnOffAllDevices() {
        allDevices.forEach(Device::turnOff);
    }

    public void turnOnDevicesInLocation(String location) {
        List<Device> devices = devicesByLocation.get(location);
        if (devices != null) {
            devices.forEach(Device::turnOn);
        }
    }

    public void turnOffDevicesInLocation(String location) {
        List<Device> devices = devicesByLocation.get(location);
        if (devices != null) {
            devices.forEach(Device::turnOff);
        }
    }
}