package org.launchcode.DirtyDishesAndEmptyPlates;

import org.launchcode.DirtyDishesAndEmptyPlates.controllers.AuthenticationController;
import org.launchcode.DirtyDishesAndEmptyPlates.models.User;
import org.launchcode.DirtyDishesAndEmptyPlates.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;
    
    private static final List<String> whitelist = Arrays.asList("/", "/error", "/login", "/logout", "/register", "/css",
      "/images", "/js", "/media");
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // (u The user is logged in
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        String uri = request.getRequestURI();
        if (!isWhitelisted(uri)) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
//    private static boolean pathsMatch(String requestedURI, String path) {
//        Pattern pattern = Pattern.compile("^(" + requestedURI + ")$|\1?");
//        return false;
//    }
    
    private static boolean isWhitelisted(String path) {
        String pathSlash = path, pathRootSlash;
        if (!path.endsWith("/")) pathSlash = path.concat("/");
        for (String pathRoot : whitelist) {
            pathRootSlash = pathRoot;
            if (!pathRoot.endsWith("/"))
                pathRootSlash = pathRoot.concat("/");
            System.out.println("path: " + path + ", " + pathSlash + "\npathRoot: " + pathRoot + ", " + pathRootSlash);
            if (path.equals(pathRoot) ||
                pathSlash.equals(pathRootSlash) ||
                (!pathRootSlash.equals("/") && (
                  (!path.endsWith("/") && pathSlash.startsWith(pathRootSlash))))) {
                System.out.println("whitelisted\n");
                return true;
            }
        }
        return false;
    }








}
