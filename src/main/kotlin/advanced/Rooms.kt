package advanced

import kotlin.random.Random

fun main() {
    val randomRoomsCount = 10
    val rooms = mutableListOf<Room>()
    val rnd = Random(42)

    for (roomIndex in 0 until randomRoomsCount) {
        val room = Room("room#$roomIndex")
        rooms.add(room)

        for (nameIndex in 0..rnd.nextInt(1, 3)) {
            val name = getRandomName()
            val neighbor = Neighbor(name)
            room.addNeighbor(neighbor)
        }
    }
    readLine()
}

