package ru.productstar.homework.delivery;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    private final static double MINIMUM_DELIVERY_AMOUNT = 400; // рублей
    private final static double FRAGILE_CARGO_DELIVERY_COST = 300; // рублей
    private final static double MAXIMUM_DISTANCE_OF_FRAGILE_CARGO_DELIVERY = 30; // км

    public static double calculationDeliveryCost(double distance, CargoSize size, boolean fragility, DeliveryServiceWorkload workload) throws UnacceptableDistanceOfFragileCargoDelivery, UnacceptableDistanceForDelivery {
        double cost;
        if (0 > distance) throw new UnacceptableDistanceForDelivery(distance);
        if (distance > MAXIMUM_DISTANCE_OF_FRAGILE_CARGO_DELIVERY && fragility)
            throw new UnacceptableDistanceOfFragileCargoDelivery();
        cost = fragility ? FRAGILE_CARGO_DELIVERY_COST : 0;
        cost += distancePrice(distance) + size.getPrice();
        cost *= workload.getFactor();
        return Math.max(cost, MINIMUM_DELIVERY_AMOUNT);
    }

    /**
     * Определяет прибавку к стоимости доставки в зависимости от расстояния.
     * @param distance расстояние
     * @return прибавку к стоимости доставки в рублях
     */
    private static double distancePrice(double distance) {
        if (2 < distance && 10 >= distance) return 100; // до 10 км
        if (10 < distance && 30 >= distance) return 200; // до 30 км
        if (30 < distance) return 300; // более 30 км
        return 50; // до 2 км
    }
}