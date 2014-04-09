package  edu.iiitb.facebook.model;

public class LastConversation {
private int user2Id;
private String user2Name;
private String lastMessageText;


public final String getUser2Name() {
	return user2Name;
}
public final void setUser2Name(String user2Name) {
	this.user2Name = user2Name;
}
public final String getLastMessageText() {
	return lastMessageText;
}
public final void setLastMessageText(String lastMessageText) {
	this.lastMessageText = lastMessageText;
}
public final int getUser2Id() {
	return user2Id;
}
public final void setUser2Id(int user2Id) {
	this.user2Id = user2Id;
}

}
