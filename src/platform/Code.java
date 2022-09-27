package platform;

import java.time.Instant;

public class Code {
    private String code;
    private Instant date;
    Code(){}
    Code(String code){
        this.code = code;
        this.date = Instant.now();
    }

    public void setCode(String code) {
        this.code = code;
        date = Instant.now();
    }

    public String getCode() {
        return code;
    }

    public Instant getDate() {
        return date;
    }

}
