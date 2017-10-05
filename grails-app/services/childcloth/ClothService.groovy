package childcloth

import grails.gorm.services.Service

@Service(Cloth)
interface ClothService {

    Cloth get(Serializable id)

    List<Cloth> list(Map args)

    Long count()

    void delete(Serializable id)

    Cloth save(Cloth cloth)

}