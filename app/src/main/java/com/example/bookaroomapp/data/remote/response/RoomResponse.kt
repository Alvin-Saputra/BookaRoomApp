package com.example.bookaroomapp.data.remote.response
import com.example.bookaroomapp.domain.model.Room
import com.google.gson.annotations.SerializedName

data class RoomResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItem(

	@field:SerializedName("room_name")
	val roomName: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: Any? = null,

	@field:SerializedName("room_code")
	val roomCode: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("facilities")
	val facilities: List<String?>? = null,

	@field:SerializedName("capacity")
	val capacity: Int? = null
){
	// Tambahkan fungsi ini untuk mapping ke model Domain
	fun toDomain(): Room {
		return Room(
			id = id ?: 0, // Jika id null, beri nilai default 0
			roomCode = roomCode ?: "",
			roomName = roomName ?: "",
			capacity = capacity ?: 0,
			// Jika facilities null, kembalikan list kosong.
			// Jika ada item yang null di dalam list, filter agar tidak masuk.
			facilities = facilities?.filterNotNull() ?: emptyList(),
			description = description ?: ""
		)
	}
}



