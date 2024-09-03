package ru.productstar.homework.delivery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bzil Kopytow <kopytow@yandex.ru>
 * @since 03.09.2024
 */
class CalculationDeliveryCostTest {

    @DisplayName("Расчёта стоимости доставки на разные расстояния маленьких нехрупких грузов, загруженность 1.")
    @Test
    void test1() {
        var cargoSize = CargoSize.SMALL;
        boolean fragility = false;
        DeliveryServiceWorkload workload = DeliveryServiceWorkload.OTHER;
        double minPrice = 400;
        double more_than_30_km = 300 + cargoSize.getPrice();
        assertAll(
                () -> assertEquals(minPrice,
                        Main.calculationDeliveryCost(1.3, cargoSize, fragility, workload)),
                () -> assertEquals(minPrice,
                        Main.calculationDeliveryCost(7.7, cargoSize, fragility, workload)),
                () -> assertEquals(minPrice,
                        Main.calculationDeliveryCost(19.1, cargoSize, fragility, workload)),
                () -> assertEquals(more_than_30_km,
                        Main.calculationDeliveryCost(50.2, cargoSize, fragility, workload))
        );
    }

    @DisplayName("Расчёта стоимости доставки на разные расстояния маленьких хрупких грузов, загруженность 1.")
    @Test
    void test2() {
        var cargoSize = CargoSize.SMALL;
        boolean fragility = true;
        DeliveryServiceWorkload workload = DeliveryServiceWorkload.OTHER;
        double up_to_2_km = 50 + cargoSize.getPrice() + 300;
        double up_to_10_km = 100 + cargoSize.getPrice() + 300;
        double up_to_30_km = 200 + cargoSize.getPrice() + 300;
        assertAll(
                () -> assertEquals(up_to_2_km,
                        Main.calculationDeliveryCost(1.3, cargoSize, fragility, workload)),
                () -> assertEquals(up_to_10_km,
                        Main.calculationDeliveryCost(7.7, cargoSize, fragility, workload)),
                () -> assertEquals(up_to_30_km,
                        Main.calculationDeliveryCost(19.1, cargoSize, fragility, workload)),
                () -> assertThrows(UnacceptableDistanceOfFragileCargoDelivery.class, () ->
                        Main.calculationDeliveryCost(50.2, cargoSize, fragility, workload))
        );
    }

    @DisplayName("Расчёта стоимости доставки на разные расстояния больших нехрупких грузов, загруженность 1.")
    @Test
    void test3() {
        var cargoSize = CargoSize.LARGE;
        boolean fragility = false;
        DeliveryServiceWorkload workload = DeliveryServiceWorkload.OTHER;
        double minPrice = 400;
        double more_than_30_km = 300 + cargoSize.getPrice();
        assertAll(
                () -> assertEquals(minPrice,
                        Main.calculationDeliveryCost(1.3, cargoSize, fragility, workload)),
                () -> assertEquals(minPrice,
                        Main.calculationDeliveryCost(7.7, cargoSize, fragility, workload)),
                () -> assertEquals(minPrice,
                        Main.calculationDeliveryCost(19.1, cargoSize, fragility, workload)),
                () -> assertEquals(more_than_30_km,
                        Main.calculationDeliveryCost(50.2, cargoSize, fragility, workload))
        );
    }

    @DisplayName("Расчёта стоимости доставки на разные расстояния больших хрупких грузов, загруженность 1.")
    @Test
    void test4() {
        var cargoSize = CargoSize.LARGE;
        boolean fragility = true;
        DeliveryServiceWorkload workload = DeliveryServiceWorkload.OTHER;
        double up_to_2_km = 50 + cargoSize.getPrice() + 300;
        double up_to_10_km = 100 + cargoSize.getPrice() + 300;
        double up_to_30_km = 200 + cargoSize.getPrice() + 300;
        assertAll(
                () -> assertEquals(up_to_2_km,
                        Main.calculationDeliveryCost(1.3, cargoSize, fragility, workload)),
                () -> assertEquals(up_to_10_km,
                        Main.calculationDeliveryCost(7.7, cargoSize, fragility, workload)),
                () -> assertEquals(up_to_30_km,
                        Main.calculationDeliveryCost(19.1, cargoSize, fragility, workload)),
                () -> assertThrows(UnacceptableDistanceOfFragileCargoDelivery.class, () ->
                        Main.calculationDeliveryCost(50.2, cargoSize, fragility, workload))
        );
    }

    @DisplayName("Расчёта стоимости доставки на расстояние до 30 км больших хрупких грузов с разной загруженностью")
    @Test
    void test5() {
        var cargoSize = CargoSize.LARGE;
        boolean fragility = true;
        var distance = 19.1;
        double other = 200 + cargoSize.getPrice() + 300;
        double increased = (200 + cargoSize.getPrice() + 300) * DeliveryServiceWorkload.INCREASED_WORKLOAD.getFactor();
        double high = (200 + cargoSize.getPrice() + 300) * DeliveryServiceWorkload.HIGH_WORKLOAD.getFactor();
        double veryHigh = (200 + cargoSize.getPrice() + 300) * DeliveryServiceWorkload.VERY_HIGH_WORKLOAD.getFactor();
        assertAll(
                () -> assertEquals(other,
                        Main.calculationDeliveryCost(distance, cargoSize, fragility,
                                DeliveryServiceWorkload.OTHER)),
                () -> assertEquals(increased,
                        Main.calculationDeliveryCost(distance, cargoSize, fragility,
                                DeliveryServiceWorkload.INCREASED_WORKLOAD)),
                () -> assertEquals(high,
                        Main.calculationDeliveryCost(distance, cargoSize, fragility,
                                DeliveryServiceWorkload.HIGH_WORKLOAD)),
                () -> assertEquals(veryHigh,
                        Main.calculationDeliveryCost(distance, cargoSize, fragility,
                                DeliveryServiceWorkload.VERY_HIGH_WORKLOAD))
        );
    }

    @DisplayName("Проверка ввода отрицательного расстояния")
    @Test
    void test6() {
        var cargoSize = CargoSize.LARGE;
        boolean fragility = true;
        assertThrows(UnacceptableDistanceForDelivery.class, () ->
                Main.calculationDeliveryCost(-10., cargoSize, fragility, DeliveryServiceWorkload.VERY_HIGH_WORKLOAD));
    }
}