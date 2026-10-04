# DECISIONS.md

## ADR-001. `double` для денежных расчётов
**Status:** Proposed
**Date:** 2026-10-04

## Context
Нужны расчёты стоимости заказа. По заданию - только примитивные типы. `double` неточен для десятичных дробей, но диапазоны ограничены, а точность - 2 знака.

## Decision
Деньги - double. Количество - int (штучный товар, 1..10 000, без переполнения).

## Consequences
- + Просто, соответствует заданию, без лишних библиотек.
- − В продакшене так нельзя: нужен BigDecimal или копейки в long.
- Риск: Если усложнение финансовой логики, то нужна миграция на BigDecimal. Расчёты уже вынесены в отдельные методы.


## ADR-002: Бизнес-правила - в константах класса
**Status:** Proposed
**Date:** 2026-10-04

## Context
Пороги (количество, цена, скидка) и ставка НДС. Вариант 1 требует смены НДС с 20% на 10%. Если числа разбросаны по коду - править придётся в нескольких местах.

## Decision
Все пороги и ставка - в public static final константах OrderCalculator:
```java
public static final double DEFAULT_VAT_RATE = 10.0;
public static final int MIN_QUANTITY = 1;
public static final int MAX_QUANTITY = 10_000;
public static final double MIN_PRICE = 0.01;
public static final double MAX_PRICE = 5_000_000.0;
public static final double MIN_DISCOUNT = 0.0;
public static final double MAX_DISCOUNT = 30.0;
```

## Consequences

- + Смена НДС - одна строка. Нет дублирования.
- − При росте проекта одна точка конфигурации станет неудобной.
- Риск: Если разные ставки для категорий, то заменить константы на enum или параметры.