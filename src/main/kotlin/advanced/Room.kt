package advanced

class Room(val name: String) {
    internal val neighbors = mutableListOf<Neighbor>()

    fun addNeighbor(neighbor: Neighbor) = neighbors.add(neighbor)

    fun getNeighbor(index: Int) = neighbors[index]

    override fun toString(): String = "Room with name $name"
}