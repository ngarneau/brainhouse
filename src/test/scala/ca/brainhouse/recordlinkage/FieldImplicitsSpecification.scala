import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

import ca.brainhouse.recordlinkage.FieldImplicits._

object FieldImplicitsSpecification extends Properties("String") {

  property("strings should have similarities") = forAll { (a: String, b: String) =>
    val sim = a.similarity(b)
    sim >= 0.0 && sim <= 1.0
  }

  property("similarity between the same string should be one") = forAll { (a: String) =>
    a.similarity(a) == 1.0
  }

}
