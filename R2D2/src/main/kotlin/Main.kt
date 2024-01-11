/**
 * Se Llama a la función para mover el robot con los valores correspondientes
 * Después se muestra posición y dirección final del robot
 */
fun main() {

    var r2d2Pos = moverRobot(10, -5, -2)
    mostrarPosicionYDireccion(r2d2Pos)


    r2d2Pos = moverRobot(0, 0, 0)
    mostrarPosicionYDireccion(r2d2Pos)


    r2d2Pos = moverRobot()
    mostrarPosicionYDireccion(r2d2Pos)


    r2d2Pos = moverRobot(-10, -5, 2)
    mostrarPosicionYDireccion(r2d2Pos)


    r2d2Pos = moverRobot(-10, -5, 2, 4, -8)
    mostrarPosicionYDireccion(r2d2Pos)
}

/**
 * Muestra la posición y dirección final del robot
 * @param r2d2Pos Triple<Int, Int, Int> posición y dirección del robot
 */
fun mostrarPosicionYDireccion(r2d2Pos: Triple<Int, Int, Int>) {
    println("x: ${r2d2Pos.first}, y: ${r2d2Pos.second}, dir: ${orientacionRobot(r2d2Pos.third)}")
}

/**
 * Devuelve la orientación del robot según el valor de la dirección
 * @param dir Int valor de la dirección
 * @return String orientación del robot
 */
fun orientacionRobot(dir: Int) = when (dir) {
    0 -> "POSITIVEY"
    1 -> "NEGATIVEX"
    2 -> "NEGATIVEY"
    3 -> "POSITIVEX"
    else -> throw IllegalArgumentException("Dirección no válida: $dir")
}

/**
 * Mueve el robot según la secuencia de pasos dada
 * @param movs vararg Int lista de movimientos que debe realizar el robot
 * @return Triple<Int, Int, Int> posición y dirección final del robot
 */
fun moverRobot(vararg movs: Int): Triple<Int, Int, Int> {
    var posX = 0
    var posY = 0
    var dir = 0 // 0 => POSITIVEY; 1 => NEGATIVEX; 2 => NEGATIVEY; 3 => POSITIVEX

    for (pasos in movs) {
        when (dir) {
            0 -> posY += pasos
            1 -> posX -= pasos
            2 -> posY -= pasos
            3 -> posX += pasos
        }
        if (dir == 3) dir = 0 else dir++
    }
    return Triple(posX, posY, dir)
}