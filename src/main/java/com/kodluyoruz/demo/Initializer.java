package com.kodluyoruz.demo;

import com.kodluyoruz.demo.model.entity.Booking;
import com.kodluyoruz.demo.model.entity.Hotel;
import com.kodluyoruz.demo.model.entity.Room;
import com.kodluyoruz.demo.model.entity.Visitor;
import com.kodluyoruz.demo.model.enums.RoomType;
import com.kodluyoruz.demo.model.location.Address;
import com.kodluyoruz.demo.repository.BookingRepository;
import com.kodluyoruz.demo.repository.HotelRepository;
import com.kodluyoruz.demo.repository.RoomRepository;
import com.kodluyoruz.demo.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner { //create data
    private final BookingRepository bookingRepository;
    private final VisitorRepository visitorRepository;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        Visitor visitor = visitorRepository.save(Visitor.builder()
                        .firstName("berat")
                        .lastName("yildirim")
                        .child(false)
                .build());

        Visitor visitor1 = visitorRepository.save(Visitor.builder()
                .firstName("testVisitor")
                .lastName("testtt")
                .child(false)
                .build());

        Hotel hotel1=hotelRepository.save(Hotel.builder()
                        .address(Address.builder().province("izmir").town("torbali").build())
                        .email("abc@gmail.com")
                        .name("HILTON")
                        .star(5)
                .build());

        Hotel hotel2=hotelRepository.save(Hotel.builder()
                .address(Address.builder().province("trabzon").town("of").build())
                .email("abc21@gmail.com")
                .name("HILTON11")
                .star(3)
                .build());
        List<Room> rooms=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String roomNumber=""+i;
            rooms.add(roomRepository.save(Room.builder()
                    .beds(2)
                    .hotelId(hotel1.getId())
                    .roomNumber(roomNumber)
                    .roomType(RoomType.STANDART)
                    .price((double)i+100)
                    .build()));
        }

        for (int i = 0; i < 10; i++) {
            String roomNumber=""+i+10;
            rooms.add(roomRepository.save(Room.builder()
                    .beds(2)
                    .hotelId(hotel2.getId())
                    .roomNumber(roomNumber)
                    .roomType(RoomType.STANDART)
                    .price((double)i+100)
                    .build()));
        }


        Date date = StringToDate("2021-11-06 17:03:00");
        Date date1 = StringToDate("2021-11-08 17:03:00");

        Date date2 = StringToDate("2021-11-09 17:03:00");
        Date date3 = StringToDate("2021-11-15 17:03:00");

        bookingRepository.save(Booking.builder()
                            .checkInDate(date)
                            .checkOutDate(date1)
                            .day(2)
                            .roomId(rooms.get(0).getId())
                            .visitorId(visitor.getId())
                    .build());

        bookingRepository.save(Booking.builder()
                .checkInDate(date2)
                .checkOutDate(date3)
                .day(1)
                .roomId(rooms.get(1).getId())
                .visitorId(visitor1.getId())
                .build());

    }
    public Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }
}