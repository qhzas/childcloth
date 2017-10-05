package childcloth

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ClothController {

    ClothService clothService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond clothService.list(params), model:[clothCount: clothService.count()]
    }
	def sell(){
		
		Cloth c=Cloth.get(params.id)
	 c.seller++
	      clothService.save(c )
	 redirect uri:'/?kind='+c.kind.id
	}
def viewImage(){
	Cloth c=Cloth.get(params.id)
	response.outputStream<<c.image
	}
    def show(Long id) {
        respond clothService.get(id)
    }

    def create() {
        respond new Cloth(params)
    }

    def save(Cloth cloth) {
        if (cloth == null) {
            notFound()
            return
        }

        try {
            clothService.save(cloth)
        } catch (ValidationException e) {
            respond cloth.errors, view:'create'
            return
        }

      redirect uri:'/'
    }

    def edit(Long id) {
        respond clothService.get(id)
    }

    def update(Cloth cloth) {
        if (cloth == null) {
            notFound()
            return
        }

        try {
            clothService.save(cloth)
        } catch (ValidationException e) {
            respond cloth.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cloth.label', default: 'Cloth'), cloth.id])
                redirect cloth
            }
            '*'{ respond cloth, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        clothService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cloth.label', default: 'Cloth'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cloth.label', default: 'Cloth'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
