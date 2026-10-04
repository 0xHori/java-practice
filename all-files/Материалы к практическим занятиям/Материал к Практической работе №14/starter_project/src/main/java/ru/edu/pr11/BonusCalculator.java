package ru.edu.pr11; public class BonusCalculator { public double calculate(EmployeePerformance p) {
 // В реализации намеренно оставлены логические дефекты. TODO 1  Найти через тесты и исправить.
 if (p.salary() < 0) return 0;
 double rate = p.kpiPercent() > 80 ? 0.15 : 0.05;
 if (p.rating() == 5) rate += 0.05;
 if (p.years() > 5) rate += 0.02;
 return p.salary() * rate;
} }
