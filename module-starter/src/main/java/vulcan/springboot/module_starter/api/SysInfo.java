package vulcan.springboot.module_starter.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vulcan.libs.utils.SystemInfo;

import java.util.Map;

@RestController
@RequestMapping("${server.servlet.context-path:}/module-starter/sys")
public class SysInfo {
    @GetMapping("/info")
    public ResponseEntity<?> info() {
        var info = Map.of(
                "mac-address", SystemInfo.macAddress.get(),
                "cpu-cores", SystemInfo.cpuCores.get()
        );
        return ResponseEntity.ok(info);
    }

    @GetMapping("/mac-address")
    public ResponseEntity<?> macAddress() {
        return ResponseEntity.ok(SystemInfo.macAddress.get());
    }

    @GetMapping("/cpu-cores")
    public ResponseEntity<?> cpuCores() {
        return ResponseEntity.ok(SystemInfo.cpuCores.get());
    }
}
