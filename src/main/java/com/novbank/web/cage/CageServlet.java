package com.novbank.web.cage;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hp on 2015/6/19.
 */
@Singleton
public class CageServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CageServlet.class);

    @Inject
    CageService service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameterMap().containsKey("reload"))
            service.clear(session);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setContentType("image/jpeg");
        service.draw(session, response.getOutputStream());
    }
}
