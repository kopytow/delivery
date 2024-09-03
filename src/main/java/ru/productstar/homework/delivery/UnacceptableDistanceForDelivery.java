package ru.productstar.homework.delivery;

/**
 * @author Bzil Kopytow <kopytow@yandex.ru>
 * @since 03.09.2024
 */
public class UnacceptableDistanceForDelivery extends Exception {
    public UnacceptableDistanceForDelivery(double distance) {
        super(String.format("Недопустимое расстояние %s км для поставки", distance));
    }
}
