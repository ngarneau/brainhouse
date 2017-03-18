import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

import ca.brainhouse.recordlinkage.ConcreteRecord

object ConcreteRecordSpecification extends Properties("Product") {

  property("combinesSameTypes") = forAll { (a: String, b: String) =>
    val r = new ConcreteRecord((a, b))
    val fields = r.getFields.toList
    fields(0) == a
    fields(1) == b
  }

  property("combinesDifferentTypes") = forAll { (a: String, b: Int, c: Float) =>
    val r = new ConcreteRecord((a, b, c))
    val fields = r.getFields.toList
    fields(0) == a
    fields(1) == b
    fields(2) == c
  }

}
