package childcloth

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ClothServiceSpec extends Specification {

    ClothService clothService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Cloth(...).save(flush: true, failOnError: true)
        //new Cloth(...).save(flush: true, failOnError: true)
        //Cloth cloth = new Cloth(...).save(flush: true, failOnError: true)
        //new Cloth(...).save(flush: true, failOnError: true)
        //new Cloth(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //cloth.id
    }

    void "test get"() {
        setupData()

        expect:
        clothService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Cloth> clothList = clothService.list(max: 2, offset: 2)

        then:
        clothList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        clothService.count() == 5
    }

    void "test delete"() {
        Long clothId = setupData()

        expect:
        clothService.count() == 5

        when:
        clothService.delete(clothId)
        sessionFactory.currentSession.flush()

        then:
        clothService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Cloth cloth = new Cloth()
        clothService.save(cloth)

        then:
        cloth.id != null
    }
}
