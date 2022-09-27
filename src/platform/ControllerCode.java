package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class ControllerCode {
    private static List<Code> codeArray;
    static{
        codeArray = new ArrayList(/*List.of(new Code("public static void main(String[] args) {\n" +
                "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
                "}"))*/);
    }



    @GetMapping(value = "/code/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getCode(@PathVariable int id, Model model) {
        model.addAllAttributes(Map.of("codeArray", List.of(codeArray.get(id-1)),
                "title","Code"));
        return "code";
    }

    @GetMapping(value = "/api/code/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getApiCode(@PathVariable int id) {
        return new ResponseEntity(codeArray.get(id - 1), HttpStatus.OK);
    }

    @GetMapping(value = "/code/new", produces = MediaType.TEXT_HTML_VALUE)
    public String getCodeNew() {
        return "newCode";
    }

    @PostMapping(value = "/api/code/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postApiCodeNew(@RequestBody Code code) {
        codeArray.add(code);
        return new ResponseEntity(Map.of("id", Integer.toString(codeArray.size())), HttpStatus.OK);
    }

    @GetMapping(value = "/api/code/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getApiCodeLatest() {
        List list = new ArrayList();
        for (int count = 0, i = codeArray.size() - 1;
             i >= 0 && count < 10;
             count++, i--){
            list.add(codeArray.get(i));
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/code/latest", produces = MediaType.TEXT_HTML_VALUE)
    public String GetCodeLatest(Model model) {
        List list = new ArrayList();
        for (int count = 0, i = codeArray.size() - 1;
             i >= 0 && count < 10;
             count++, i--){
            list.add(codeArray.get(i));
        }
        model.addAllAttributes(Map.of("codeArray" ,list,
                "title","Latest"));
        return "code";
    }
}
