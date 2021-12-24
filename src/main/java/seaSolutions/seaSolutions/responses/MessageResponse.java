package seaSolutions.seaSolutions.responses;

public interface MessageResponse {
	
	public default MessageResponseImpl createMessageResponse(String text) {
		return new MessageResponseImpl(text);
	}
}