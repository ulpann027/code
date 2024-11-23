public class DeliveryClient {
    public static void main(String[] args) {
        IInternalDeliveryService deliveryService = DeliveryServiceFactory.getDeliveryService("externalA");
        deliveryService.deliverOrder("12345");
        System.out.println(deliveryService.getDeliveryStatus("12345"));
    }
}

interface IInternalDeliveryService {
    void deliverOrder(String orderId);
    String getDeliveryStatus(String orderId);
}

class InternalDeliveryService implements IInternalDeliveryService {
    @Override
    public void deliverOrder(String orderId) {
        System.out.println("Delivering order: " + orderId);
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        return "Status of order " + orderId;
    }
}

class ExternalLogisticsServiceA {
    public void shipItem(int itemId) {
        System.out.println("Shipping item: " + itemId);
    }

    public String trackShipment(int shipmentId) {
        return "Tracking shipment " + shipmentId;
    }
}

class LogisticsAdapterA implements IInternalDeliveryService {
    private ExternalLogisticsServiceA externalService;

    public LogisticsAdapterA(ExternalLogisticsServiceA externalService) {
        this.externalService = externalService;
    }

    @Override
    public void deliverOrder(String orderId) {
        int itemId = Integer.parseInt(orderId);
        externalService.shipItem(itemId);
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        int shipmentId = Integer.parseInt(orderId);
        return externalService.trackShipment(shipmentId);
    }
}

class DeliveryServiceFactory {
    public static IInternalDeliveryService getDeliveryService(String type) {
        if ("internal".equalsIgnoreCase(type)) {
            return new InternalDeliveryService();
        } else if ("externalA".equalsIgnoreCase(type)) {
            return new LogisticsAdapterA(new ExternalLogisticsServiceA());
        }
        return null;
    }
}
