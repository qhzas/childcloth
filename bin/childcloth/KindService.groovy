package childcloth

import grails.gorm.services.Service

@Service(Kind)
interface KindService {

    Kind get(Serializable id)

    List<Kind> list(Map args)

    Long count()

    void delete(Serializable id)

    Kind save(Kind kind)

}