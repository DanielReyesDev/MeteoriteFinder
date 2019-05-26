import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCObjectBase.OverrideInit
import kotlinx.cinterop.ObjCOutlet
import platform.Foundation.*
import platform.UIKit.*
import platform.MapKit.*
import platform.CoreLocation.CLLocationCoordinate2DMake


@ExportObjCClass
class MeteoriteMapViewController : UIViewController, MKMapViewDelegateProtocol {

    @OverrideInit
    constructor(coder: NSCoder) : super(coder)

    @ObjCOutlet
    lateinit var mapView: MKMapView


    override fun viewDidLoad() {
        super.viewDidLoad()

        val center = CLLocationCoordinate2DMake(38.8935754, -77.0847873)
        val span = MKCoordinateSpanMake(0.7, 0.7)
        val region = MKCoordinateRegionMake(center, span)

        with(mapView){
            delegate = this@MeteoriteMapViewController
            setRegion(region, true)
        }

        createAnnotation()
    }

    fun createAnnotation() {
        val annotation = MKPointAnnotation().apply {
            setCoordinate(CLLocationCoordinate2DMake(38.8935754, -77.0847873))
            setTitle("My mock meteorite")
            setSubtitle("I'm falling........")
        }

        mapView.addAnnotation(annotation)
    }

    override fun mapViewDidFailLoadingMap(mapView: MKMapView, withError: NSError) {
        NSLog("Error loading map: $withError")
    }

}