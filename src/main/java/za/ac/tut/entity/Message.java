package za.ac.tut.entity;

public class Message {

	private String name;
    private String text;

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message from " + name + ": " + text;
    }
    
    
}

