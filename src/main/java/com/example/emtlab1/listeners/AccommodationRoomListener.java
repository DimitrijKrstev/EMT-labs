package com.example.emtlab1.listeners;

import com.example.emtlab1.model.events.AccommodationNoRoomsEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccommodationRoomListener {
    @EventListener
    public void onNoMoreRoom(AccommodationNoRoomsEvent event){
        System.out.println(event.toString());
    }
}
