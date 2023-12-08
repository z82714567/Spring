package kr.chhak.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import kr.chhak.model.ChatRoom;
import kr.chhak.service.ChatService;

import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatService chatService;
    
    @GetMapping(value = {"/", "/index"})
    public String index() {
    	return "/index";
    }
    
    // 채팅 리스트 화면
    @GetMapping("/chat/room")
    public String rooms(Model model) {
        return "/chat/room";
    }
    
    // 모든 채팅방 목록 반환
    @GetMapping("/chat/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
    	
    	log.info("room...");
    	
        return chatService.findAllRoom();
    }
    
    // 채팅방 생성
    @PostMapping("/chat/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestBody Map<String, String> requestMap) {
    	
    	String name = requestMap.get("name");
    	log.info("createRoom...1 : " + name);
        return chatService.createRoom(name);
    }
    
    // 채팅방 입장 화면
    @GetMapping("/chat/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
    	
    	log.info("roomDetail... : " + roomId);
    	
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }
    
    // 특정 채팅방 조회
    @GetMapping("/chat/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatService.findById(roomId);
    }
}