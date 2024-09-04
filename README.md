# delivery
## Домашнее задание для урока “Тест-раннеры юнит-тестирования для Java: JUnit, TestNG”
### Задача. Вам нужно написать функцию расчёта стоимости доставки.
Стоимость рассчитывается в зависимости от:
　　　расстояния до пункта назначения:
　　　●более 30 км: +300 рублей к доставке;
　　　●до 30 км: +200 рублей к доставке;
　　　●до 10 км: +100 рублей к доставке;
　　　●до 2 км: +50 рублей к доставке;
　　　габаритов груза:
　　　●большие габариты: +200 рублей к доставке;
　　　●маленькие габариты: +100 рублей к доставке;
　　　хрупкости груза. Если груз хрупкий — +300 рублей к доставке. Хрупкие грузы нельзя возить на расстояние более 30 км;
　　　загруженности службы доставки. Стоимость умножается на коэффициент доставки:
　　　●очень высокая загруженность — 1.6;
　　　●высокая загруженность — 1.4;
　　　●повышенная загруженность — 1.2;
　　　●во всех остальных случаях коэффициент равен 1.
Минимальная сумма доставки — 400 рублей. Если сумма доставки меньше минимальной, выводится минимальная сумма.
На входе функция получает расстояние до пункта назначения, габариты, информацию о хрупкости, загруженность службы на текущий момент. На выходе пользователь получает стоимость доставки.
### Что нужно сделать:
　　　●напишите код-решение для этой задачи;
　　　●покройте своё решение юнит тестами. Ответ приложите в виде ссылки на репозиторий;
　　　●Задание со звездочкой: посчитать процент покрытия используя Test Coverage, настроить Allure отчеты

## Анализ сущностей
расстояние до пункта назначения - distance - перечисление
	up_to_2_km(50) - до 2 км - 
	Up_to_10_km(100) - до 10 км - 
	UP_TO_30_KM(200) - до 30 км - 
	MORE_THAN_30_KM(300) - более 30 км - 
Нет реализации из-за сложности сравнения с вводимым расстоянием. Скорее всего нужен класс, отвечающий за эти действия.

груз - cargo
	габарит - size - перечисление
		большой - large
		маленький - small
	хрупкость - fragility - равен истине, если груз хрупкий, иначе ложь.
Для упрощения программы реализовано перечисление.

служба доставки - delivery service
	загруженность - workload - перечисление
		очень высокая загруженность - very high workload
		высокая загруженность - high workload
		повышенная загруженность - increased workload
		во всех остальных случаях - other
Также для упрощения программы реализовано перечисление.

Константы:
	Минимальная сумма доставки — MINIMUM_DELIVERY_AMOUNT = 400
	Стоимость перевозки хрупких грузов - FRAGILE_CARGO_DELIVERY_COST = 300
	Максимальное расстояние доставки хрупких грузов - MAXIMUM_DISTANCE_OF_FRAGILE_CARGO_DELIVERY = 30
Введены два исключения:
	UnacceptableDistanceOfFragileCargoDelivery - выбрасывается, если расстояние доставки хрупких грузов больше константы MAXIMUM_DISTANCE_OF_FRAGILE_CARGO_DELIVERY.
	UnacceptableDistanceForDelivery - выбрасывается, если введено отрицательное значение расстояния.

