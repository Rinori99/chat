package server.mappers;

import server.DTOs.ChatUserDTO;
import server.models.ChatUser;

public class UserMapper {

    public static ChatUserDTO chatUserToChatUserDTO(ChatUser chatUser) {
        return new ChatUserDTO(chatUser.getId(), chatUser.getFirstName(), chatUser.getLastName(), chatUser.getChatRole(), chatUser.getEmail());
    }

}
