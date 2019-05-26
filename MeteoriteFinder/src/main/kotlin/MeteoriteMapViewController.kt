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

    val lat = 38.8935754
    val lon = -77.0847873


    override fun viewDidLoad() {
        super.viewDidLoad()

        val center = CLLocationCoordinate2DMake(lat, lon)
        val span = MKCoordinateSpanMake(0.005, 0.005)
        val region = MKCoordinateRegionMake(center, span)

        with(mapView){
            delegate = this@MeteoriteMapViewController
            setRegion(region, true)
        }

        createAnnotation()
    }

    fun createAnnotation() {
        val annotation = MKPointAnnotation().apply {
            setCoordinate(CLLocationCoordinate2DMake(lat, lon))
            setTitle("My mock meteorite")
            setSubtitle("I'm falling........")
        }

        mapView.addAnnotation(annotation)
    }

    override fun mapViewDidFailLoadingMap(mapView: MKMapView, withError: NSError) {
        NSLog("Error loading map: $withError")
    }

}