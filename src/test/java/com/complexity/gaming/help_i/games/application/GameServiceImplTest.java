package com.complexity.gaming.help_i.games.application;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {
    @Test
    void testCreateStringFromLongListWithOutBrackets(){
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(1L);
        ids.add(1L);
        ids.add(1L);

        String fields = ids.toString();
        fields = fields.substring(1,fields.length()-1);

        Assert.isTrue(fields.equals("1, 1, 1, 1"), "Fields are not equal");
    }
}