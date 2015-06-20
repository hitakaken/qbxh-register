package com.novbank.web.cage;

import com.github.cage.Cage;
import com.github.cage.GCage;
import com.google.inject.Singleton;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by hp on 2015/6/19.
 */
@Singleton
public class CageService {
    private static final String CAGE_TEXT_KEY = "cage_text";
    private static final String CAGE_TIME_KEY = "cage_time";
    private long cacheTime;
    private TimeUnit cacheTimeUnit;
    private long cacheMilliseconds;

    public CageService(long cacheTime, TimeUnit cacheTimeUnit) {
        this.cacheTime = cacheTime;
        this.cacheTimeUnit = cacheTimeUnit;
        cacheMilliseconds = cacheTimeUnit.toMillis(cacheTime);
    }

    public void draw(HttpSession session, OutputStream outputStream) throws IOException {
        Cage cage = new GCage();
        cage.draw(getText(session,cage),outputStream);
    }

    public String getText(HttpSession session, Cage cage){
        Date cageTime = (Date) session.getAttribute(CAGE_TIME_KEY);
        Date current = new Date();
        if(cageTime == null || current.getTime() - cageTime.getTime() > cacheMilliseconds){
            if(cage!=null){
                String text =cage.getTokenGenerator().next().substring(2,8);
                session.setAttribute(CAGE_TEXT_KEY,text);
                session.setAttribute(CAGE_TIME_KEY,current);
                return text;
            }else{
                clear(session);
                return null;
            }
        }else
            return (String) session.getAttribute(CAGE_TEXT_KEY);
    }

    public boolean match(HttpSession session, String text){
        String cache = getText(session,null);
        return cache!=null && StringUtils.equals(cache,text);
    }

    public void clear(HttpSession session) {
        session.removeAttribute(CAGE_TEXT_KEY);
        session.removeAttribute(CAGE_TIME_KEY);
    }
}
