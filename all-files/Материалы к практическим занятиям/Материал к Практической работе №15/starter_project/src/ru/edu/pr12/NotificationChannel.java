package ru.edu.pr12; public interface NotificationChannel { boolean supports(NotificationRequest r); NotificationResult send(NotificationRequest r); }
