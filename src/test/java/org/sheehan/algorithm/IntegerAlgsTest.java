package org.sheehan.algorithm;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by bsheehan on 2/12/16.
 */
public class IntegerAlgsTest extends TestCase {

    @Test
    public void testReverseInteger() {

        System.out.println(IntegerAlgs.reverseDecInt(1234));
        System.out.println(IntegerAlgs.reverseDecInt(-1234));
        System.out.println(IntegerAlgs.reverseDecInt2(1234));
        System.out.println(IntegerAlgs.reverseDecInt2(-1234));
    }
}