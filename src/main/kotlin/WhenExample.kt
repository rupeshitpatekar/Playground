fun whatToDo(dayOfWeek: Any) = when(dayOfWeek){
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work Hard"
    in 2..4 -> "Work Hard"
    "Friday" -> "Party"
    is String -> "What?"
    else -> "No clue"
}