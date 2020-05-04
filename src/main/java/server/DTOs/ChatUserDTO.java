package server.DTOs;

public class ChatUserDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String chatRole;

    public ChatUserDTO() {}

    public ChatUserDTO(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ChatUserDTO(String id, String firstName, String lastName, String chatRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.chatRole = chatRole;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getChatRole() {
        return chatRole;
    }

    public void setChatRole(String chatRole) {
        this.chatRole = chatRole;
    }

}
