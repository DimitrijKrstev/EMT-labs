package com.example.emtlab1.model.events;

import com.example.emtlab1.model.Accommodation;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AccommodationNoRoomsEvent extends ApplicationEvent {
    String accomodationName;

    public AccommodationNoRoomsEvent(Accommodation source) {
        super(source);
        accomodationName = source.getName();
    }

    @Override
    public String toString() {
        return "No more room in " + accomodationName;
    }
}
