package ru.productstar.homework.delivery;

/**
 * @author Bzil Kopytow <kopytow@yandex.ru>
 * @since 03.09.2024
 */
public enum DeliveryServiceWorkload {
    // очень высокая загруженность
    VERY_HIGH_WORKLOAD(1.6),
    // высокая загруженность
    HIGH_WORKLOAD(1.4),
    // повышенная загруженность
    INCREASED_WORKLOAD(1.2),
    // во всех остальных случаях
    OTHER(1);

    private final double factor;

    DeliveryServiceWorkload(double price) {
        this.factor = price;
    }

    public double getFactor() {
        return factor;
    }
}
