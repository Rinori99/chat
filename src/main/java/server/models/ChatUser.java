package server.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat_user")
public class ChatUser {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "chat_role")
    private String chatRole;

    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "conversation_participant",
            joinColumns = { @JoinColumn(name = "chat_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "conversation_id") }
    )
    private List<Conversation> conversations;

    public ChatUser() {}

    public ChatUser(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ChatUser(String id, String firstName, String lastName, String chatRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.chatRole = chatRole;
    }

    public ChatUser(String id, String firstName, String lastName, String chatRole, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.chatRole = chatRole;
        this.email = email;
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

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
