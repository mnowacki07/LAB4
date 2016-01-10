package dad;

public class Message {

	public int id;
	public String text;
	public Priority priority;

	Message(int id, String text, Priority priority) {
		this.id = id;
		this.text = text;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Message id:" + id + ", text:" + text + ", priority:" + priority;
	}

}