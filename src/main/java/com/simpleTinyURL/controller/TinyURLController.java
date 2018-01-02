package com.simpleTinyURL.controller;

import com.simpleTinyURL.model.TinyURL;
import com.simpleTinyURL.service.TinyURLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrro1015 on 1/2/2018.
 */
@RestController
public class TinyURLController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TinyURLController.class);
    private static final String URL_NOT_REGISTERED = "Your tiny URL is not registered.";
    @Autowired
    private TinyURLService tinyURLService;

    @PostMapping(value = "/createTinyURL")
    public TinyURL createTinyURL(@RequestBody TinyURL tinyURL) {
        LOGGER.debug("Going to create tinyURL with {}", tinyURL);
        tinyURLService.create(tinyURL);
        return tinyURL;
    }

    /*@GetMapping("/{tinyURL}")
    @ResponseBody
    public String redirectURL(@PathVariable(name = "tinyURL") String tinyURL) {
        return tinyURL;
    }*/

    @RequestMapping(value = "/{tinyURL}")
    void redirectTinyURL(@PathVariable("tinyURL") String tinyURL, HttpServletResponse response) throws IOException {
        TinyURL tinyURLObj = new TinyURL();
        tinyURLObj.setTinyUrl(tinyURL);
        tinyURLObj = tinyURLService.find(tinyURLObj);
        if (tinyURLObj == null) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(URL_NOT_REGISTERED);
            response.getWriter().flush();
            response.getWriter().close();
        } else {
            response.sendRedirect(tinyURLObj.getOriginalURL());
        }
    }
}
