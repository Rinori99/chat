package server.controllers;

import org.springframework.web.bind.annotation.*;
import server.DTOs.ChatUserDTO;
import server.DTOs.ConversationDTO;
import server.DTOs.OnlineMeetingDTO;
import server.services.ConversationService;
import server.services.OnlineMeetingService;

import java.util.List;

@RestController
@RequestMapping("/conversations")
public class ConversationController {

    private ConversationService conversationService;
    private OnlineMeetingService onlineMeetingService;

    public ConversationController(ConversationService conversationService, OnlineMeetingService onlineMeetingService) {
        this.conversationService = conversationService;
        this.onlineMeetingService = onlineMeetingService;
    }

    @PostMapping
    public ConversationDTO createConversation(@RequestParam("email") String email) {
        return conversationService.createConversation(email);
    }

    @GetMapping("/{conversationId}/participants")
    public List<ChatUserDTO> getUsersByConversation(@PathVariable String conversationId) {
        return conversationService.getUsersByConversationId(conversationId);
    }

    @GetMapping("/{conversationId}/online-meetings")
    public List<OnlineMeetingDTO> getOnlineMeetingsByConversationId(@PathVariable String conversationId) {
        return onlineMeetingService.getOnlineMeetingsByConversationId(conversationId);
    }

}
