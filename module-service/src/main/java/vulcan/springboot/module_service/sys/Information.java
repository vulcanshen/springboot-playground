package vulcan.springboot.module_service.sys;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vulcan.libs.utils.SystemInfo;

import java.util.Map;

@RestController
@RequestMapping("/${module-service.api-prefix:module-service}/sys/info")
public class Information {

    @GetMapping
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
