// Подсистема бронирования номеров
class RoomBookingSystem {
    void bookRoom() { System.out.println("Номер забронирован."); }
    void checkAvailability() { System.out.println("Проверка доступности номера."); }
    void cancelBooking() { System.out.println("Бронирование номера отменено."); }
}

// Подсистема ресторана
class RestaurantSystem {
    void bookTable() { System.out.println("Столик в ресторане забронирован."); }
    void orderFood() { System.out.println("Еда заказана."); }
}

// Подсистема управления мероприятиями
class EventManagementSystem {
    void bookConferenceRoom() { System.out.println("Конференц-зал забронирован."); }
    void orderEquipment() { System.out.println("Оборудование заказано."); }
}

// Служба уборки
class CleaningService {
    void scheduleCleaning() { System.out.println("Уборка запланирована."); }
    void performCleaning() { System.out.println("Уборка выполнена."); }
}

// Фасад отеля
class HotelFacade {
    private RoomBookingSystem roomBooking;
    private RestaurantSystem restaurant;
    private EventManagementSystem eventManagement;
    private CleaningService cleaning;

    public HotelFacade(RoomBookingSystem roomBooking, RestaurantSystem restaurant, EventManagementSystem eventManagement, CleaningService cleaning) {
        this.roomBooking = roomBooking;
        this.restaurant = restaurant;
        this.eventManagement = eventManagement;
        this.cleaning = cleaning;
    }

    void bookRoomWithFoodAndCleaning() {
        roomBooking.bookRoom();
        restaurant.orderFood();
        cleaning.scheduleCleaning();
        System.out.println("Номер с едой и уборкой забронирован.");
    }

    void organizeEventWithRoomsAndEquipment() {
        eventManagement.bookConferenceRoom();
        roomBooking.bookRoom();
        eventManagement.orderEquipment();
        System.out.println("Мероприятие с оборудованием и номерами организовано.");
    }

    void bookTableWithTaxi() {
        restaurant.bookTable();
        System.out.println("Столик и такси заказаны.");
    }
}

// Клиентский код
public class jj {
    public static void main(String[] args) {
        RoomBookingSystem roomBooking = new RoomBookingSystem();
        RestaurantSystem restaurant = new RestaurantSystem();
        EventManagementSystem eventManagement = new EventManagementSystem();
        CleaningService cleaning = new CleaningService();
        HotelFacade hotel = new HotelFacade(roomBooking, restaurant, eventManagement, cleaning);

        hotel.bookRoomWithFoodAndCleaning();
        hotel.organizeEventWithRoomsAndEquipment();
        hotel.bookTableWithTaxi();
    }
}
