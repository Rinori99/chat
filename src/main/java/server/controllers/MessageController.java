package server.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import server.DTOs.ChatMessageDTO;
import server.services.MessageService;

import java.security.Principal;
import java.util.List;

@Controller
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/message/{conversationId}")
    @SendTo("/topic/chat/{conversationId}")
    public ChatMessageDTO messageCommunication(@DestinationVariable String conversationId, ChatMessageDTO message, Principal principal) {
        messageService.saveMessage(message.getSenderId(), message.getConversationId(), message.getContent(), message.getTimeSent());
        return message;
    }

    @GetMapping("/my-messages/{conversationId}")
    public List<ChatMessageDTO> getMessagesByConversationId(@PathVariable String conversationId) {
        return null;
    }

}
