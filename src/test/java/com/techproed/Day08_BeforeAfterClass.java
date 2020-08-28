package com.techproed;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day08_BeforeAfterClass {
    @AfterClass // bu annotationa sahip method her classtaki tester çalıştırıldıktan sonra çalışır.
    public static void tearDown(){
        System.out.println("tearDown çalıştı.");
    }
    @Test
    public void test1(){
        System.out.println("Test 1 çalıştı.");
    }
    @Test
    public void test2(){
        System.out.println("Test 2 çalıştı.");
    }
    @BeforeClass // bu annotationa sahip method her class çalışmadan önce çalışır.
    public static void setUp(){
        System.out.println("setUp çalıştı.");
    }




}
