package com.example.hostelbackend.controller;

import com.example.hostelbackend.models.Room;
import com.example.hostelbackend.repository.RoomRepository;
import com.example.hostelbackend.services.RoomService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/room")
public class RoomController {
    private final RoomRepository roomRepository;
    private final RoomService roomService;

    public RoomController(RoomRepository roomRepository, RoomService roomService) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
    }
    @GetMapping("/add")
    public String addRoom(Model model){
        model.addAttribute("rooms", new Room());
        return "Rooms/addRoom";
    }
    @PostMapping("/add")
    public String addRoom(@ModelAttribute("rooms") @Valid Room room, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("Возникла ошибка при добавлении Номера");
            return "Rooms/addRoom";
        }
        roomService.saveRoom(room);
        return "redirect:/admin";
    }
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") int id){
        roomService.deleteRoom(id);
        return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String editRoom(Model model, @PathVariable("id") int id){
        model.addAttribute("rooms",roomService.getRoomId(id));
        return "Rooms/editRoom";
    }
    @PostMapping("/edit/{id}")
    public String editRoom(@ModelAttribute("rooms") @Valid Room room, BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            System.out.println("Возникла ошибка при редактировании Номера");
            return "Rooms/editRoom";
        }
        roomService.updateRoom(id, room);
        return "redirect:/admin";
    }
}
