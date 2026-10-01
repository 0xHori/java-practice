package ru.edu.pr10;
import java.time.*; import java.util.*;
public class BookingService { private final BookingRepository repo; public BookingService(BookingRepository r){repo=r;}
 public Booking book(String id,String room,LocalDateTime start,LocalDateTime end,LocalDateTime now) { /* TODO 1 */ return null; }
 public boolean isAvailable(String room,LocalDateTime start,LocalDateTime end) { /* TODO 2 */ return false; }
 boolean overlaps(Booking b,LocalDateTime start,LocalDateTime end) { /* TODO 3 */ return false; }
}
