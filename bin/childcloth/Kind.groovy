package childcloth

class Kind {
Category category
String name
String toString(){
	return this.name
	}
    static constraints = {
		name(unique:true)
    }
}
