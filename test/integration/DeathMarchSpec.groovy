import spock.lang.*

class DeathMarchSpec extends Specification {
	def 'Flushes take more time every test'() {
		setup:
			def start = System.currentTimeMillis()
		expect:
			new Thing().save(flush:true)
			logTime(x, start)
		where:
			x << (1..100000 as List)
	}

	private def logTime(long x, long start) {
		println "DeathMarchSpec :: $x :: time taken :: ${System.currentTimeMillis() - start}"
		true
	}
}
 
