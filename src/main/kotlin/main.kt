import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("Введите сколько минут назад человек был в сети:")
        val seconds = scanner.nextInt()*60 //перевод в секунды
        agoToText(seconds)
    }
}

fun agoToText(seconds: Int) {
    when {
        seconds in 0..60 -> println("был(а) только что")
        seconds in 61..3600 -> println("был(а) ${checkMinutesSuffix(seconds)} назад")
        seconds in 3601..86400 -> println("был(а) ${checkHoursSuffix(seconds)} назад")
        seconds in 86401..172800 -> println("был(а) сегодня")
        seconds in 172801..259200 -> println("был(а) вчера")
        seconds > 259201 -> println("был(а) давно")
    }
}

fun checkMinutesSuffix(seconds: Int): String {
    val minutes = seconds / 60 //перевод в минуты
    when (minutes % 100) {
        11, 12, 13, 14 -> return "$minutes минут"
    }
    return when (minutes % 10) {
        1 -> "$minutes минуту"
        2, 3, 4 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun checkHoursSuffix(seconds: Int): String {
    val hours = seconds / 60 / 60 //перевод в часы
    when (hours % 100) {
        11, 12, 13, 14 -> return "$hours часов"
    }
    return when (hours % 10) {
        1 -> "$hours час"
        2, 3, 4 -> "$hours часа"
        else -> "$hours часов"
    }
}