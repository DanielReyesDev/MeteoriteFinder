import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCObjectBase.OverrideInit
import kotlinx.cinterop.ObjCOutlet
import platform.Foundation.*
import platform.UIKit.*
import platform.MapKit.*

@ExportObjCClass
class MeteoriteMapViewController : UIViewController, MKMapViewDelegateProtocol {

    @OverrideInit
    constructor(coder: NSCoder) : super(coder)

    override fun viewDidLoad() {
        super.viewDidLoad()
    }
}