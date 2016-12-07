package school.lemon.changerequest.java.oop.pr1

import spock.lang.Specification
import spock.lang.Unroll

import static school.lemon.changerequest.java.oop.pr1.FractionNumber.ONE
import static school.lemon.changerequest.java.oop.pr1.FractionNumber.ZERO


/**
 * Created by isergiichuk on 07.12.16.
 */
class FractionNumberSpecification extends Specification {
    def "should throw IllegalArgumentException if divisor if 0"() {
        when:
        new FractionNumber(1, 0)
        then:
        thrown(IllegalArgumentException)
    }


    @Unroll
    def "normalized #dividend should be #normalizedDividend. #divisor should be #normalizedDivisor"() {
        when:
        def fn = new FractionNumber(dividend, divisor)
        then:
        fn.getDividend() == normalizedDividend
        fn.getDivisor() == normalizedDivisor
        where:
        dividend | divisor || normalizedDividend || normalizedDivisor
        9        | 3       || 3                  || 1
        3        | 3       || 1                  || 1
        1        | 4       || 1                  || 4
        12       | 16      || 3                  || 4
        25       | 45      || 5                  || 9
        -9       | 3       || -3                 || 1
        9        | -3      || -3                 || 1
        -3       | -3      || 1                  || 1
        0        | 3       || 0                  || 1
        0        | -3      || 0                  || 1
    }

    @Unroll
    def "multiplication of #fr1 and #fr2 should be #expectedResult"() {
        expect:
        fr1 * fr2 == expectedResult
        where:
        fr1      | fr2          || expectedResult
        fr(3)    | fr(3)        || fr(9)
        fr(5, 3) | fr(7, 2)     || fr(35, 6)
        fr(6, 2) | fr(8, 2)     || fr(12)
        fr(-3)   | fr(3)        || fr(-9)
        fr(3)    | fr(3, -1)    || fr(-9)
        fr(-3)   | fr(3, -1)    || fr(9)
        ZERO     | fr(25, 6)    || ZERO
        ONE      | fr(235, 142) || fr(235, 142)
        ONE      | ZERO         || ZERO
    }

    @Unroll
    def "division of #fr1 and #fr2 should be #expectedResult"() {
        expect:
        fr1 / fr2 == expectedResult
        where:
        fr1           | fr2          || expectedResult
        fr(3)         | fr(3)        || ONE
        fr(5, 3)      | fr(7, 2)     || fr(10, 21)
        fr(-6, 2)     | fr(8, -2)    || fr(3, 4)
        fr(-3)        | fr(3)        || fr(-1)
        ONE           | fr(235, 142) || fr(142, 235)
        ZERO          | fr(124, 15)  || ZERO
        fr(241, 1265) | ONE          || fr(241, 1265)
    }

    @Unroll
    def "getDecimalValue of #fractionNumber should return #expectedResult"() {
        expect:
        fractionNumber.getDecimalValue() == expectedResult
        where:
        fractionNumber || expectedResult
        fr(3, 4)       || 0.75
        fr(4)          || 4.0
        fr(1, 2)       || 0.5
        ZERO           || 0d
        ONE            || 1d
        fr(-1)         || -1d
        fr(1, -1)      || -1d
        fr(-1, -1)     || 1
    }

    @Unroll
    def "plus of #fr1 and #fr2 should be #expectedResult"() {
        expect:
        fr1 + fr2 == expectedResult
        where:
        fr1           | fr2          || expectedResult
        fr(3)         | fr(3)        || fr(6)
        fr(5, 3)      | fr(7, 2)     || fr(31, 6)
        fr(6, 2)      | fr(8, 2)     || fr(7)
        fr(-3)        | fr(3)        || ZERO
        fr(-3)        | fr(3, -1)    || fr(-6)
        ONE           | fr(235, 142) || fr(377, 142)
        ZERO          | fr(124, 15)  || fr(124, 15)
        fr(241, 1265) | ONE          || fr(1506, 1265)
    }

    @Unroll
    def "minus of #fr1 and #fr2 should be #expectedResult"() {
        expect:
        fr1 - fr2 == expectedResult
        where:
        fr1           | fr2          || expectedResult
        fr(3)         | fr(3)        || ZERO
        fr(5, 3)      | fr(7, 2)     || fr(-11, 6)
        fr(6, 2)      | fr(8, 2)     || fr(-1)
        fr(-3)        | fr(3)        || fr(-6)
        fr(-3)        | fr(3, -1)    || ZERO
        ONE           | fr(235, 142) || fr(-93, 142)
        ZERO          | fr(124, 15)  || fr(-124, 15)
        fr(241, 1265) | ONE          || fr(-1024, 1265)
    }

    def fr(long dividend, long divisor) {
        return new FractionNumber(dividend, divisor)
    }

    def fr(long dividend) {
        return new FractionNumber(dividend)
    }
}