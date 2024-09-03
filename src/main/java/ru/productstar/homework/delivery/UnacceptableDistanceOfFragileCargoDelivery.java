package ru.productstar.homework.delivery;

/**
 * @author Bzil Kopytow <kopytow@yandex.ru>
 * @since 03.09.2024
 */
public class UnacceptableDistanceOfFragileCargoDelivery extends Exception {
    public UnacceptableDistanceOfFragileCargoDelivery() {
        super("Недопустимое расстояние перевозки хрупких грузов!");
    }
}
