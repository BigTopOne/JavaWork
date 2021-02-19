package com.jar;

import java.util.Random;

public class ApiTest {
    public String queryGirlFriendCount(String boyFriendName){
        return boyFriendName+ "的前女友数量"+(new Random().nextInt(10)+1)+"个";
    }
}
