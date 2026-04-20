package com.example.bookaroomapp.model

class Room(
    val id: Int,
    val roomCode: String,
    val roomName: String,
    val capacity: Int,
    val facilities: List<String>,
    val description: String
) {
    companion object {
        val dummyRoom = listOf(
            Room(
                1,
                "ROOM-7",
                "Melati",
                10,
                listOf("TV", "Papan Tulis"),
                "Internal Meeting"
            ),  Room(
                2,
                "ROOM-7",
                "Melati",
                10,
                listOf("TV", "Papan Tulis"),
                "Internal Meeting"
            ),  Room(
                3,
                "ROOM-7",
                "Melati",
                10,
                listOf("TV", "Papan Tulis"),
                "Internal Meeting"
            ),
        )
    }
}