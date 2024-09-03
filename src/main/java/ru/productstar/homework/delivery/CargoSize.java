package ru.productstar.homework.delivery;

/**
 * @author Bzil Kopytow <kopytow@yandex.ru>
 * @since 03.09.2024
 */
public enum CargoSize {
    LARGE(200),
    SMALL(100);

    private final double price;

    CargoSize(double price) {
        this.price = price; // в рублях
    }

    public double getPrice() {
        return price;
    }
}
