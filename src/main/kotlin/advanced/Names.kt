package advanced

import java.io.File
import kotlin.random.Random

// names.txt from https://www.usna.edu/Users/cs/roche/courses/s15si335/proj1/
private val names = File("./src/main/kotlin./advanced/names.txt").readText().split("\n")
private val namesCount = names.size
private val rnd = Random(42)

fun getRandomName() = names[rnd.nextInt(0, namesCount-1)]