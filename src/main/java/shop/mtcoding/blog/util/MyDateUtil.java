package shop.mtcoding.blog.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.util.Date;

// 이제부터 모든 팀원이 이 것을 재사용할 수 있다.
public class MyDateUtil {
    public static String timestampFormat(Timestamp time) {
        Date currentDate = new Date(time.getTime());

        // 원하는 포맷으로 날짜를 변환
        return DateFormatUtils.format(currentDate, "yyyy-MM-dd HH:mm");
    }
}
