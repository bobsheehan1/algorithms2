package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 6/27/14
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringsTest {

    @Test
    public void testReverse() throws Exception {
        String testStr = "hello";

        String reverseStr = Strings.reverse(testStr);
        System.out.println(reverseStr);
        Assert.assertEquals("olleh", reverseStr);
    }

    @Test
    public void testReverse2() throws Exception {
        String testStr = "hello there";

        String reverseStr = Strings.reverse(testStr.toCharArray(), 6, testStr.length() - 1);
        System.out.println(reverseStr);
        Assert.assertEquals("hello ereht", reverseStr);
    }

    @Test
    public void testReverse3() throws Exception {
        String testStr = "hello there";

        String reverseStr = Strings.reverseWords(testStr);
        System.out.println(reverseStr);
        Assert.assertEquals("olleh ereht", reverseStr);
    }

    @Test
    public void testPermutations() throws Exception {
        String testStr = "ABC";

        Set<String> cache = new HashSet<String>();

        Strings.getPermutations("", "ABC", cache);

        for (String s: cache)
            System.out.println(s);
    }

    @Test
    public void testStrToInt() throws Exception {
        System.out.println(Strings.strToInt("1234"));
        System.out.println(Strings.strToInt("-1234"));
    }


    @Test
    public void testRotations() throws Exception {
        String testStr = "ABC";
        String testStr2 = "BCA";
        Assert.assertTrue(Strings.isRotation(testStr, testStr2));
        testStr = "ABC";
        testStr2 = "CBA";
        Assert.assertFalse(Strings.isRotation(testStr, testStr2));
    }

    private String generate(int length){
        int numberOfUuids = length/32 + 1;
        String str="";
        for (int i = 0; i < numberOfUuids; ++i) {
            String uuid = UUID.randomUUID().toString();
            uuid = uuid.replace("-", "");
            str += uuid;
        }

        return str.substring(0, length);
    }

    @Test
    public void testRandomStrings(){
        String str = generate(10);
        Assert.assertTrue(str.length() == 10);
        String str2 = generate(40);
        Assert.assertTrue(str2.length() == 40);
    }

    @Test
    public void testFirstNonRepeat(){
        for (int i = 0; i < 5; ++i) {
            String str = generate(20);
            System.out.println(str);
            char c = Strings.getFirstNonRepeatingChar(str);
            System.out.println(c);
        }
    }

    @Test
    public void testIntToString(){

        int num = 1234;
        String str = Strings.intToStr(num);
        System.out.println(str);

    }

    @Test
    public void testFindDuplicates(){
        String test = "ABABCDEFGHGH";
        Set<Character> duplicates = Strings.findDuplicates(test);
        duplicates.forEach(s -> System.out.print(s + " "));
    }

    @Test
    public void testRemoveDuplicates(){
        String test = "ABABCDEFGHGH";
        String s = Strings.removeDuplicates(test);
        System.out.println(s);
    }


}
