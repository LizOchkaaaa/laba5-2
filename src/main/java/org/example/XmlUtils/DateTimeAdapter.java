package org.example.XmlUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Date;

public class DateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {

//        private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
//
//        @Override
//        public String marshal(Date v) {
//            return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(v);
//        }
//
//        @Override
//        public Date unmarshal(String v) throws ParseException {
//            return new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(v);
//        }


    final static DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z");

    @Override
    public String marshal(ZonedDateTime v) {
        ZonedDateTime zdtInLocalTimeline = v.withZoneSameInstant(ZoneId.systemDefault());
        return zdtInLocalTimeline.toString();
    }

    @Override
    public ZonedDateTime unmarshal(String v) throws ParseException {
        /*преобразования стороки в объект*/
        ZonedDateTime zdtWithZoneOffset = ZonedDateTime.parse(v, formatter);
        return zdtWithZoneOffset;
    }
}