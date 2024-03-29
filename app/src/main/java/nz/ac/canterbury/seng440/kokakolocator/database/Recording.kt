package nz.ac.canterbury.seng440.kokakolocator.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import java.io.File
import java.util.*

@Entity(tableName = Recording.TABLE_NAME)
class Recording(
    val fileName: String,
    val latLng: LatLng?,
    val dateTime: Date,
    var serverId: Long? = null,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
) {
    companion object {
        const val TABLE_NAME = "recordings"
}

    override fun toString(): String {
        return "Date & Time: $dateTime | Location: ${if (latLng != null) "(${latLng.latitude}, ${latLng.longitude})" else "Unknown"})"
    }

    val file: File
        get() {
            return File(fileName)
        }
}