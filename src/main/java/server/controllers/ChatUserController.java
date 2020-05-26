package server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.DTOs.ConversationDTO;
import server.PerRequestIdStorage;
import server.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/chat-users")
public class ChatUserController {

    private UserService userService;

    public ChatUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/conversations/")
    public List<ConversationDTO> getConversationsByUserId() {
        return userService.getConversationsByUserId(PerRequestIdStorage.getUserId());
    }

}
