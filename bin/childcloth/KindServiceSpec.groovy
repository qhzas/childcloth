package childcloth

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class KindServiceSpec extends Specification {

    KindService kindService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Kind(...).save(flush: true, failOnError: true)
        //new Kind(...).save(flush: true, failOnError: true)
        //Kind kind = new Kind(...).save(flush: true, failOnError: true)
        //new Kind(...).save(flush: true, failOnError: true)
        //new Kind(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //kind.id
    }

    void "test get"() {
        setupData()

        expect:
        kindService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Kind> kindList = kindService.list(max: 2, offset: 2)

        then:
        kindList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        kindService.count() == 5
    }

    void "test delete"() {
        Long kindId = setupData()

        expect:
        kindService.count() == 5

        when:
        kindService.delete(kindId)
        sessionFactory.currentSession.flush()

        then:
        kindService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Kind kind = new Kind()
        kindService.save(kind)

        then:
        kind.id != null
    }
}
