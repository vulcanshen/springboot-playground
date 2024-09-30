package vulcan.springboot.opentelemetry.javaagent;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuggyService {
    private List<String> list = new ArrayList<>();

    @Setter(onMethod_ = @Autowired)
    private Utils utils;

    public String create() {
        int counterLimit = 10;
        if (list.size() >= counterLimit) {
            throw new RuntimeException("limit reached");
        }
        var string = utils.randomString(20);
        list.add(string);
        return string;
    }

    public String pop() {
        return list.remove(0);
    }

}
