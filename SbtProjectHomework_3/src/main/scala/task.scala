import scala.collection.mutable

private object CellEvaluationContext {
  private val _currentPath: ThreadLocal[mutable.Stack[(Int, Int)]] =
    ThreadLocal.withInitial(() => mutable.Stack.empty[(Int, Int)])
  private val _visitedCoords: ThreadLocal[mutable.Set[(Int, Int)]] =
    ThreadLocal.withInitial(() => mutable.Set.empty[(Int, Int)])

  def enterCell(ix: Int, iy: Int): Boolean = {
    val currentCoord = (ix, iy)
    val visited = _visitedCoords.get()
    val path = _currentPath.get()
    if (visited.contains(currentCoord)) {
      true
    } else {
      path.push(currentCoord)
      visited.add(currentCoord)
      false // Цикла нет
    }
  }
  def exitCell(): Unit = {
    val path = _currentPath.get()
    if (path.nonEmpty) {
      val (ix, iy) = path.pop()
      _visitedCoords.get().remove((ix, iy))
    }
  }
  def resetContext(): Unit = {
    _currentPath.get().clear()
    _visitedCoords.get().clear()
  }
}

trait Cell {
  override def toString(): String
}

case object EmptyCell extends Cell {
  override def toString(): String = "empty"
}

class NumberCell(val number: Int) extends Cell {
  override def toString(): String = number.toString
}

class StringCell(val text: String) extends Cell {
  override def toString(): String = text
}

class ReferenceCell(val targetIx: Int, val targetIy: Int, val table: Table) extends Cell {
  override def toString(): String = {
    val selfCoords = table.findCellCoordinates(this)
    if (selfCoords.isEmpty) {
      return "error: ReferenceCell not found in its own table during evaluation"
    }
    val (selfIx, selfIy) = selfCoords.get
    if (!table.isValidCoordinate(targetIx, targetIy)) {
      return "outOfRange"
    }
    if (CellEvaluationContext.enterCell(selfIx, selfIy)) {
      CellEvaluationContext.exitCell()
      return "cyclic"
    }
    try {
      table.getCell(targetIx, targetIy) match {
        case Some(targetCell) =>
          targetCell.toString()
        case None =>
          "error: referenced cell not found after valid coordinate check"
      }
    } finally {
      CellEvaluationContext.exitCell()
    }
  }
}

class Table(val width: Int, val height: Int) {
  private val cells: Array[Cell] = Array.fill(width * height)(EmptyCell)
  private def get1DIndex(ix: Int, iy: Int): Int = ix + iy * width

    def isValidCoordinate(ix: Int, iy: Int): Boolean =
    ix >= 0 && ix < width && iy >= 0 && iy < height

    def findCellCoordinates(cell: Cell): Option[(Int, Int)] = {
    for (iy <- 0 until height; ix <- 0 until width) {
      if (cells(get1DIndex(ix, iy)) eq cell) {
        return Some((ix, iy))
      }
    }
    None
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (isValidCoordinate(ix, iy)) {
      Some(cells(get1DIndex(ix, iy)))
    } else {
      None
    }
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (isValidCoordinate(ix, iy)) {
      val index = get1DIndex(ix, iy)
      cells(index) = cell
    }
  }

  def getCellValue(ix: Int, iy: Int): Option[String] = {
    CellEvaluationContext.resetContext()
    getCell(ix, iy).map(_.toString())
  }
}