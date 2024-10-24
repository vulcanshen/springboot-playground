package dev.vulcan.springboot.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Optional;
import java.util.function.Supplier;

public class SystemInfo {

    public static Supplier<Integer> cpuCores = () -> Runtime.getRuntime().availableProcessors();

    public static Supplier<Optional<String>> macAddress = () -> {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
            byte[] hardwareAddress = ni.getHardwareAddress();
            String[] hexadecimal = new String[hardwareAddress.length];
            for (int i = 0; i < hardwareAddress.length; i++) {
                hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
            }
            String macAddress = String.join("-", hexadecimal);
            return Optional.of(macAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    };
}
