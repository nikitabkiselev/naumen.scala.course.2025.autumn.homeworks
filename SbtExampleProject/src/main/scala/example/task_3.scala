object MainApp extends App {
  // Имя разработчика
  //val developerName = "Никита Киселев"
  val developerName = "Nikita Kiselev"

  // Первоначальное приветствие
  // println(s"Привет, Скала! Это $developerName")
  println(s"Hi, Scala! This is $developerName")
  // Новый список приветствий
  val greetings = List("Hola", "Guten Tag")

  // Формируем и выводим приветствия с новым словом
  //greetings.foreach(greeting => println(s"$greeting, Скала!"))
  greetings.foreach(greeting => println(s"$greeting, Scala!"))
  // Списки имен гостей
  //val guestsNames = List(
  //  "Иван Московченко",
  //  "Ольга Михайлова",
  //  "Сергей Иванов",
  //  "Елена Викторова"
  //)

  val guestsNames = List(
    "Paul Jones",
    "Jimmy Rogers",
    "John Peterson",
    "Helena Wang"
  )
  // Функция для переворота каждой части имени
  def reverseEachWord(name: String): String = {
    name.split(" ").map(_.reverse).mkString(" ") // Разделяем по пробелам, переворачиваем каждую часть и объединяем обратно
  }

  // Перевернутые имена гостей
  val reversedGuestsNames = guestsNames.map(reverseEachWord)

  // Новая форма приветствия с перевёрнутым именем гостя
  //reversedGuestsNames.foreach(reversedName => println(s"Добро пожаловать, $reversedName!"))
  //}
  reversedGuestsNames.foreach(reversedName => println(s"Welcome, $reversedName!"))
}
