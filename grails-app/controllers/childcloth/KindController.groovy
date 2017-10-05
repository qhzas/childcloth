package childcloth

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class KindController {

    KindService kindService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond kindService.list(params), model:[kindCount: kindService.count()]
    }

    def show(Long id) {
        respond kindService.get(id)
    }

    def create() {
        respond new Kind(params)
    }

    def save(Kind kind) {
        if (kind == null) {
            notFound()
            return
        }

        try {
            kindService.save(kind)
        } catch (ValidationException e) {
            respond kind.errors, view:'create'
            return
        }

      redirect uri:'/'
    }

    def edit(Long id) {
        respond kindService.get(id)
    }

    def update(Kind kind) {
        if (kind == null) {
            notFound()
            return
        }

        try {
            kindService.save(kind)
        } catch (ValidationException e) {
            respond kind.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'kind.label', default: 'Kind'), kind.id])
                redirect kind
            }
            '*'{ respond kind, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        kindService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'kind.label', default: 'Kind'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kind.label', default: 'Kind'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
