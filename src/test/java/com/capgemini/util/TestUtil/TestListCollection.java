package com.capgemini.util.TestUtil;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestListCollection {
    @Test
    public void testsize() {
        List<String> l = new ArrayList<>();
        l.add("Homer Simpson");
        l.add("Bart Simpson");
        l.add("Marge Simpson");

        //Act ---- ejecucion

        int i=3;
        int j= l.size();
        //int j=0;

        //Assert ---- acertacion

        Assert.assertTrue ( "list size it not equal", i==j);

        //Assert.assertFalse("List size is not Empty",  j == 0 );


    }
}
