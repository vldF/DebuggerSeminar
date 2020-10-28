package advanced

fun roomRenderer(room: Room): String {
    return buildString {
        for ((index, neighbor) in room.neighbors.withIndex()) {
            append("#$index: $neighbor ")
        }
    }
}