package com.scaffolding.scaffolding.helper;

import java.time.LocalDateTime;

public class DateHelper {
    
    public static LocalDateTime getActualDateTime () {
        return LocalDateTime.now().withNano(0);
    }
}
