package ru.edu.pr07; public class DeliveryPolicyFactory { public DeliveryPolicy get(DeliveryType type) { /* TODO 5 */ return new PickupPolicy(); } }
