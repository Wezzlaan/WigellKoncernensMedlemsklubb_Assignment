package com.vestrin.members;

import java.io.Serializable;
import java.util.Random;

public class ID_Randomizer implements Serializable {

    private final Random random;

    protected ID_Randomizer(){
        random = new Random();
    }

    /**GENERATES RANDOM NUMBER BETWEEN 11111 AND 99999
     * @return random new ID
     */
    protected String generate(){
        return String.valueOf(random.nextInt(11111,99999));
    }
}
