package com.example.bookaroomapp.domain.model

data class Booking(
    val id: Int,
    val userName: String,
    val roomName: String,
    val startTime: String,
    val endTime: String,
    val purpose: String,
    val status: String,
    val bookedAt: String,
)

val dummyBooking = listOf(

    Booking(
        1,
        "Rina",
        "Melati",
        "2025-11-01T11:15:00.000Z",
        "2025-11-01T12:15:00.000Z",
        "Internal Meeting",
        "Pending",
        "2026-03-19T10:36:32.000Z"
    ),
    Booking(
        2,
        "Udin",
        "Mawar",
        "2025-11-01T11:15:00.000Z",
        "2025-11-01T12:15:00.000Z",
        "Internal Meeting",
        "Pending",
        "2026-03-19T10:36:32.000Z"
    ),
    Booking(
        3,
        "Mamat",
        "Raflesia",
        "2025-11-01T11:15:00.000Z",
        "2025-11-01T12:15:00.000Z",
        "Internal Meeting",
        "Pending",
        "2026-03-19T10:36:32.000Z"
    ),
)
