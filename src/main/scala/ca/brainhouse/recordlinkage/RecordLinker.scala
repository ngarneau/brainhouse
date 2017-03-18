package ca.brainhouse.recordlinkage
import scalaz.Memo
import scala.language.implicitConversions

trait Record
trait RecordId


case class StringId(id: String) extends RecordId

class ConcreteRecord(fields: Product) extends Record {
  def getFields = fields.productIterator
}

class StringField(s: String) {

  def levenshtein(s1: String, s2: String): Int = {
    lazy val lev: ((Int, Int)) => Int = Memo.mutableHashMapMemo[(Int, Int), Int] {
      case (i, 0) => i
      case (0, j) => j
      case (i, j) => Seq(
        lev((i - 1, j)) + 1,
        lev((i, j - 1)) + 1,
        lev((i - 1, j - 1)) + (if (s1(i - 1) == s2(j - 1)) 0 else 1)).min
    }
    lev((s1.length, s2.length))
}
  def similarity(other: String): Double = {
    val longestLength = List(s, other).map(_.length()).max.toDouble
    val d = levenshtein(s, other)
    d match {
      case 0 => 1.0
      case _ =>  longestLength / (longestLength + d)
    }
  }
}

object FieldImplicits {
  implicit def enrichString(s: String) = new StringField(s)
}


class RecordLinker(dataset: List[Record]) {

  def link(r: Record): RecordId = {
    StringId("Some Id")
  }

}
