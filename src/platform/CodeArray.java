package platform;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "codeArray")
public class CodeArray {
    List<Code> codeArray;
    public void initz(String code){
        this.codeArray = new ArrayList<Code>();
        this.codeArray.add(new Code(code));
    }

    public List<Code> getCodeArray() {
        return codeArray;
    }

    public void setCodeArray(String code) {
        codeArray.add(new Code(code));
    }
    public Code get(int index){
        return codeArray.get(index);
    }
    public int size(){
        return codeArray.size();
    }

}
