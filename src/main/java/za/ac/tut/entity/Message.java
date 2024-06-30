package za.ac.tut.entity;
import java.util.List;
public class Message {

	private String name;
    private String msg;
    private List<String> data;

    public Message(String name, String msg, List<String> data) {
        this.name = name;
        this.msg = msg;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
