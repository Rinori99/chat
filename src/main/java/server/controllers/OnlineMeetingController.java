package server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import server.DTOs.OnlineMeetingDTO;
import server.services.OnlineMeetingService;

import java.util.List;

@RestController
@RequestMapping("online-meetings")
public class OnlineMeetingController {

    private OnlineMeetingService onlineMeetingService;

    public OnlineMeetingController(OnlineMeetingService onlineMeetingService) {
        this.onlineMeetingService = onlineMeetingService;
    }

    @GetMapping
    public List<OnlineMeetingDTO> getOnlineMeetingsByConversationId(@RequestParam String conversationId) {
        return onlineMeetingService.getOnlineMeetingsByConversationId(conversationId);
    }

}
