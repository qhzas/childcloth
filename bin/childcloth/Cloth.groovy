package childcloth

class Cloth {
Kind kind
String title
byte[] image
int seller
double price
    static constraints = {
		image(maxSize:128000)
		seller(display:false)
    }
}
